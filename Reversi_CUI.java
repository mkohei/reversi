public class Reversi_CUI {
    // -------------------------------
    // ---------- CONSTANTS ----------
    // -------------------------------

    // ----------------------------
    // ---------- FIELDS ----------
    // ----------------------------

    // ---------------------------------
    // ---------- CONSTRUCTOR ----------
    // ---------------------------------

    // --------------------------
    // ---------- MAIN ----------
    // --------------------------
    public static void main(String args[]) {
        Reversi reversi = new Reversi();
        reversi.init();

        //showCUI(reversi.getBoard());
        showCUI_markCanPut(reversi, Reversi.BLACK);
        showCUI_markCanPut(reversi, Reversi.WHITE);
    }

    // -----------------------------
    // ---------- METHODS ----------
    // -----------------------------
    public static void showCUI(int[][] board) {
        System.out.println("  a b c d e f g h");
        String row;
        String s;
        for (int j=0; j<board.length; j++) {
            row = ""+(j+1)+"|";
            for (int i=0; i<board.length; i++) {
                if (board[j][i] == Reversi.EMPTY) s = " ";
                else if (board[j][i] == Reversi.WHITE) s = "○"; // 白
                else s = "●"; // 黒
                row += s + "|";
            }
            System.out.println(row);
        }
    }

    public static void showCUI_markCanPut(Reversi reversi, int val) {
        int[][] board = reversi.getBoard();
        System.out.println("  a b c d e f g h");
        String row;
        String s;
        for (int j=0; j<board.length; j++) {
            row = ""+(j+1)+"|";
            for (int i=0; i<board.length; i++) {
                if (board[j][i] == 0)
                    if (reversi.canPut(i, j, val)) s = "c";
                    else s = " ";
                else if (board[j][i] > 0) s = "○"; // 白
                else s = "●"; // 黒
                row += s + "|";
            }
            System.out.println(row);
        }
    }
}