package com.example.starlitya.onlineassement.leetcode;


/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

 */
public class Word_search_Jerry {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        // default as falase as not used
        boolean [][] record = new boolean[board.length][board[0].length];
        // TODO better use board[i][j] = 0 to replace

        // find start point first
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, record, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] record, String word, int wordIndex
            , int i, int j) {
        if (wordIndex == word.length()) {
            return true;
        }

        // better to use board[i].length here
        if (i<0 || j<0 || i>=board.length || j>=board[i].length) {
            return false;
        }

        boolean found = false;
        if (record[i][j] == false && board[i][j] == word.charAt(wordIndex)) {
            record[i][j] = true;
            found = search(board, record, word, wordIndex+1, i-1, j) ||
                    search(board, record, word, wordIndex+1, i, j-1) ||
                    search(board, record, word, wordIndex+1, i+1, j) ||
                    search(board, record, word, wordIndex+1, i, j+1);

            record[i][j] = false;
        }

        return found;
    }

    public boolean exist_old(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        // default as falase as not used
        boolean [][] record = new boolean[board.length][board[0].length];
        return search(board, record, word, 0, -1, -1);
    }

    private boolean search_old(char[][] board, boolean[][] record, String word, int wordIndex
            , int lastX, int lastY) {
        if (wordIndex == word.length()) {
            return true;
        }

        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[0].length; j++) {
                // check position
                if (lastX != -1 && lastY != -1 &&
                        !isAdjacent(i, j, lastX, lastY)) {
                    continue;
                }

                if (record[i][j] == false) {
                    if (board[i][j] == word.charAt(wordIndex)) {
                        record[i][j] = true;
                        boolean found = search(board, record, word, wordIndex+1, i, j);
                        if (found) {
                            return true;
                        }
                        record[i][j] = false;
                    }
                }
            }
        }

        return false;
    }

    private boolean isAdjacent(int i, int j, int lastX, int lastY) {
        if (i == lastX-1 && j == lastY) {
            return true;
        } else if(i == lastX && j == lastY-1) {
            return true;
        } else if(i == lastX && j == lastY+1) {
            return true;
        } else if(i == lastX+1 && j == lastY) {
            return true;
        }
        return false;
    }
}