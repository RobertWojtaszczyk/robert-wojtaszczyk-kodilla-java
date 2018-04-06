package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuAlgorithm {
    private SudokuBoard sudokuBoard;

    public SudokuAlgorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean resolveSudoku() {
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
                        return noFieldPossibleValues();
                    } else {
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

                        if (currentElement.getPossibleValues().size() == 1) {
                            currentElement.setValue(currentElement.getPossibleValues().get(0));
                            currentElement.getPossibleValues().clear();
                            actionPerformed = true;
                        }
                    }
                }
            }
        }
        int numberOfEmptyFields = sudokuBoard.getSudokuRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElements().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .map(sudokuElement -> 1)
                .reduce(0,(sum, current) -> sum = sum + current);

        if (numberOfEmptyFields == 0) {
            System.out.println(sudokuBoard);
            return false;
        } else {
            return actionPerformed || guessValueForEmptyElement();
        }
    }

    private boolean guessValueForEmptyElement() {
        SudokuElement firstEmptyElement = null;
        int firstEmptyElementValue;
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

        if ((firstEmptyElement != null) && (firstEmptyElement.getPossibleValues().size() > 0)) {
            SudokuBoard clonedSudokuBoard = null;
            SudokuBoardDTO sudokuBoardDTO = null;
            firstEmptyElementValue = firstEmptyElement.getPossibleValues().get(0);
            try {
                clonedSudokuBoard = sudokuBoard.deepCopy();
                sudokuBoardDTO = new SudokuBoardDTO(clonedSudokuBoard, firstEmptyElementValue, firstEmptyElementRow, firstEmptyElementColumn);
                SudokuBacktrack.getBacktrack().add(sudokuBoardDTO);
            } catch (CloneNotSupportedException e) {
                System.out.println("Failed making a copy of current board" + e);   //print e -> ???????????????????????????
            }
            firstEmptyElement.setValue(firstEmptyElementValue); //  SETTING UP A GUESS VALUE TO CHOSEN FIELD!!!
            return true;
        }
        return false;
    }

    private boolean noFieldPossibleValues() {
        if (SudokuBacktrack.getBacktrack().size() > 0) {
            SudokuBoardDTO previousCopy = SudokuBacktrack.getBacktrack().get(SudokuBacktrack.getBacktrack().size() - 1);
            sudokuBoard = previousCopy.getSudokuBoard();
            sudokuBoard.getSudokuRows().get(previousCopy.getGuessSudokuElementRow()).getSudokuElements().get(previousCopy.getGuessSudokuElementColumn())
                    .getPossibleValues().remove(new Integer(previousCopy.getGuessSudokuElementValue()));
            SudokuBacktrack.getBacktrack().remove(SudokuBacktrack.getBacktrack().size() - 1);
            return true;
        } else {
            System.out.println("Algorithm ERROR! Noting to restore!");
            return false;
        }
    }
}