package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {
    private SudokuBoard sudokuBoard;
    private int numberOfIterations = 0;

    public Algorithm(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean resolveSudoku() {
        boolean actionPerformed = false;
        numberOfIterations++;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                SudokuElement currentElement = generateCurrentElement(row, column);
                List<SudokuElement> currentRow = generateCurrentRow(row);
                List<SudokuElement> currentColumn = generateCurrentColumn(column);
                List<SudokuElement> currentSection = generateCurrentSection(row, column);

                if (currentElement.getValue() != SudokuElement.EMPTY) {
                    if (currentElement.getPossibleValues().size() > 0) {    //sprawdzać czy za każdym razem czyścić?
                        currentElement.getPossibleValues().clear();
                    }
                } else {
                    if (currentElement.getPossibleValues().size() == 0) {
                        return emptyPossibleValuesListError();
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

                        List<Integer> valuesToPutInCurrentField = currentElement.getPossibleValues().stream()
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
                        if (valuesToPutInCurrentField.size() > 0) {
                            currentElement.setValue(valuesToPutInCurrentField.get(0));
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

        if (countEmptyFields() == 0) {
            UserDialogs.printResults(sudokuBoard, numberOfIterations);
            return false;
        } else {
            return actionPerformed || guessValueForEmptyElement();
        }
    }

    public boolean validateBoardValues() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                SudokuElement currentElement = generateCurrentElement(row, column);
                List<SudokuElement> currentRow = generateCurrentRow(row);
                List<SudokuElement> currentColumn = generateCurrentColumn(column);
                List<SudokuElement> currentSection = generateCurrentSection(row, column);if (currentElement.getValue() != SudokuElement.EMPTY) {
                int numberOfDoubledValues;
                numberOfDoubledValues = currentRow.stream()
                        .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                        .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                        .map(sudokuElement -> 1)
                        .reduce(0, (sum, current) -> sum = sum + current);
                numberOfDoubledValues += currentColumn.stream()
                        .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                        .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                        .map(sudokuElement -> 1)
                        .reduce(0, (sum, current) -> sum = sum + current);
                numberOfDoubledValues += currentSection.stream()
                        .filter(sudokuElement -> !sudokuElement.equals(currentElement))
                        .filter(sudokuElement -> sudokuElement.getValue() == currentElement.getValue())
                        .map(sudokuElement -> 1)
                        .reduce(0, (sum, current) -> sum = sum + current);

                    if (numberOfDoubledValues > 0) {
                        UserDialogs.wrongSudokuValues();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int countEmptyFields() {
        return sudokuBoard.getSudokuRows().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuElements().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .map(sudokuElement -> 1)
                .reduce(0,(sum, current) -> sum = sum + current);
    }

    private SudokuElement generateCurrentElement(int row, int column) {
        return sudokuBoard.getSudokuRows().get(row).getSudokuElements().get(column);
    }

    private List<SudokuElement> generateCurrentRow(int row) {
        return new ArrayList<>(sudokuBoard.getSudokuRows().get(row).getSudokuElements());
    }

    private List<SudokuElement> generateCurrentColumn(int column) {
        List<SudokuElement> currentColumn = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            currentColumn.add(sudokuBoard.getSudokuRows().get(i).getSudokuElements().get(column));
        }
        return currentColumn;
    }

    private List<SudokuElement> generateCurrentSection(int row, int column) {
        List<SudokuElement> currentSection = new ArrayList<>();
        int blockY = 3 * (row / 3);
        int blockX = 3 * (column / 3);
        for (int j = blockY; j < blockY + 3; j++) {
            for (int i = blockX; i < blockX +3; i++) {
                currentSection.add(sudokuBoard.getSudokuRows().get(j).getSudokuElements().get(i));
            }
        }
        return currentSection;
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
            firstEmptyElementValue = firstEmptyElement.getPossibleValues().get(0);
            try {
                SudokuBoard clonedSudokuBoard = sudokuBoard.deepCopy();
                BoardState boardState = new BoardState(clonedSudokuBoard, firstEmptyElementValue, firstEmptyElementRow, firstEmptyElementColumn);
                Backtrack.getBacktrack().add(boardState);
            } catch (CloneNotSupportedException e) {
                System.out.println("Failed making a copy of current board" + e);   //print e -> ???
                throw new InternalError(e); //???????????????????
//                return false;
            }
            firstEmptyElement.setValue(firstEmptyElementValue);
            return true;
        } else {
            System.out.println("Algorithm ERROR!");
            return false;
        }

    }

    private boolean emptyPossibleValuesListError() {
        if (Backtrack.getBacktrack().size() > 0) {
            BoardState previousCopy = Backtrack.getBacktrack().get(Backtrack.getBacktrack().size() - 1);
            sudokuBoard = previousCopy.getSudokuBoard();
            sudokuBoard.getSudokuRows().get(previousCopy.getGuessSudokuElementRow()).getSudokuElements().get(previousCopy.getGuessSudokuElementColumn())
                    .getPossibleValues().remove(new Integer(previousCopy.getGuessSudokuElementValue()));
            Backtrack.getBacktrack().remove(Backtrack.getBacktrack().size() - 1);
            return true;
        }
        System.out.println("Algorithm ERROR! Noting to restore!");
        return false;
    }
}