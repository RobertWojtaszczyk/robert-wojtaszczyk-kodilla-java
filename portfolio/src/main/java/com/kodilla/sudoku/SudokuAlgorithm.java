package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SudokuAlgorithm {
    private SudokuBoard sudokuBoard;

    public SudokuAlgorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean resolveSudoku() throws SudokuAlgorithmException {
        boolean actionPerformed = false;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                SudokuElement currentElement = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x);
                List<SudokuElement> currentRow = new ArrayList<>(sudokuBoard.getSudokuRows().get(y).getSudokuElements());
                List<SudokuElement> currentColumn = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(x));
                }
                List<SudokuElement> currentSection = new ArrayList<>();
                int blockY = 3 * (y / 3);
                int blockX = 3 * (x / 3);
                for (int j = blockY; j < blockY + 3; j++) {
                    for (int i = blockX; i < blockX +3; i++) {
                        currentSection.add(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(i));
                    }
                }

                if (currentElement.getValue() != SudokuElement.EMPTY) {
                    if (currentElement.getPossibleValues().size() > 0) {
                        currentElement.getPossibleValues().clear();
                    }
                } else {
                    if (currentElement.getPossibleValues().size() == 0) {
                        System.out.println("Warning! No possible values: " + y + ":" + x + currentElement.getPossibleValues());
                        if (noFieldPossibleValues()) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    // #1
                    List<Integer> newPossibleValues = currentElement.getPossibleValues().stream()
                            .filter(possibleValue -> currentRow.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentColumn.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .filter(possibleValue -> currentSection.stream()
                                    .noneMatch(sudokuElement -> sudokuElement.getValue() == possibleValue))
                            .collect(Collectors.toList());
                    if (!newPossibleValues.equals(currentElement.getPossibleValues())) {
                        currentElement.setPossibleValues(newPossibleValues);
                        actionPerformed = true;
                    }

                    // #2
                    List<Integer> elementsToPutInCurrentField = currentElement.getPossibleValues().stream()
                            .filter(possibleValue -> currentRow.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .filter(possibleValue -> currentColumn.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .filter(possibleValue -> currentSection.stream()
                                    .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                                    .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                                        .noneMatch(possibleValue::equals))
                            .collect(Collectors.toList());
                    if (elementsToPutInCurrentField.size() > 0) {
                        currentElement.setValue(elementsToPutInCurrentField.get(0));
                        currentElement.getPossibleValues().clear();
                        actionPerformed = true;
                    }

                    // #3
                    if (currentElement.getPossibleValues().size() == 1) {
                        if (currentRow.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                        if (currentColumn.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                        if (currentSection.stream()
                                .anyMatch(sudokuElement -> sudokuElement.getValue() == currentElement.getPossibleValues().get(0))) {
                            throw new SudokuAlgorithmException();
                        }
                    }

                    // if last possible value put it to field value
                    if (currentElement.getPossibleValues().size() == 1) {
                        currentElement.setValue(currentElement.getPossibleValues().get(0));
                        currentElement.getPossibleValues().clear();
                        actionPerformed = true;
                    }

                }
            }
        }
        int numberOfEmptyFields = sudokuBoard.getSudokuRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElements().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .map(sudokuElement -> 1)
                .reduce(0,(sum, current) -> sum = sum + current);
        System.out.println("Empty fields: " + numberOfEmptyFields);

        if (numberOfEmptyFields == 0) {
            System.out.println(sudokuBoard);
            return false;
        } else if (actionPerformed) {
            return true;
        } else {
            guessValueForEmptyElement();
            return true;
        }
    }

    public boolean guessValueForEmptyElement() {
        SudokuElement firstEmptyElement = null;
        int firstEmptyElementValue = 0;
        int firstEmptyElementRow = 0;
        int firstEmptyElementColumn = 0;
        boolean abort = false;
        for (int y = 0; y < 9 && !abort; y++) {
            for (int x = 0; x < 9 && !abort; x++) {
                if (sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x).getValue() == SudokuElement.EMPTY) {
                    firstEmptyElement = sudokuBoard.getSudokuRows().get(y).getSudokuElements().get(x);
                    firstEmptyElementRow = y;
                    firstEmptyElementColumn = x;
                    abort = true;
                }
            }
        }
        System.out.println("empty element: Row/Column = " + firstEmptyElementRow + "/" + firstEmptyElementColumn);

        if ((firstEmptyElement != null) && (firstEmptyElement.getPossibleValues().size() > 0)) {
            SudokuBoard clonedSudokuBoard = null;
            SudokuBoardDTO sudokuBoardDTO = null;
            firstEmptyElementValue = firstEmptyElement.getPossibleValues().get(0);
            try {
                clonedSudokuBoard = sudokuBoard.deepCopy();
                sudokuBoardDTO = new SudokuBoardDTO(clonedSudokuBoard, firstEmptyElementValue, firstEmptyElementRow, firstEmptyElementColumn);
                SudokuBacktrack.getBacktrack().add(sudokuBoardDTO);
                System.out.println("Controll, adding copy for: " + firstEmptyElementRow + ":" + firstEmptyElementColumn + " value=" + firstEmptyElementValue);
                System.out.println("Controll, possible values: " + firstEmptyElement.getPossibleValues());
                System.out.println("Controll, copied possible values: " + clonedSudokuBoard.getSudokuRows().get(firstEmptyElementRow).getSudokuElements().get(firstEmptyElementColumn).getPossibleValues());
            } catch (CloneNotSupportedException e) {
                System.out.println("Failed making a copy of current board" + e);   //print e -> ???????????????????????????
            }
            System.out.println("GuessNumber: Puting value: " + firstEmptyElementValue + " from possibilities: " + firstEmptyElement.getPossibleValues());

            firstEmptyElement.setValue(firstEmptyElementValue); //  SETTING UP A GUESS VALUE TO CHOSEN FIELD!!!
            return true;
        }
        return false;
    }

    private boolean noFieldPossibleValues() {
        System.out.println("numbers of copies: " + SudokuBacktrack.getBacktrack().size());
        if (SudokuBacktrack.getBacktrack().size() > 0) {
            SudokuBoardDTO previousCopy = SudokuBacktrack.getBacktrack().get(SudokuBacktrack.getBacktrack().size() - 1);
            System.out.println("######Restoring element possible values: " + previousCopy.getSudokuBoard().getSudokuRows().get(previousCopy.getGuessSudokuElementRow()).getSudokuElements().get(previousCopy.getGuessSudokuElementColumn()).getPossibleValues());

            System.out.println("@Test, before restore:\n" + sudokuBoard);
            sudokuBoard = previousCopy.getSudokuBoard();
            System.out.println("@Test, after restore:\n" + sudokuBoard);

            sudokuBoard.getSudokuRows().get(previousCopy.getGuessSudokuElementRow()).getSudokuElements().get(previousCopy.getGuessSudokuElementColumn())
                    .getPossibleValues().remove(new Integer(previousCopy.getGuessSudokuElementValue()));
            System.out.println("###Restored element new possible values: " + sudokuBoard.getSudokuRows().get(previousCopy.getGuessSudokuElementRow()).getSudokuElements().get(previousCopy.getGuessSudokuElementColumn())
                    .getPossibleValues());

            SudokuBacktrack.getBacktrack().remove(SudokuBacktrack.getBacktrack().size() - 1);
            return true;
        } else {
            System.out.println("Algorithm ERROR!!!");
            return false;
        }
    }
}