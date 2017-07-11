public class Reversi {
    // -------------------------------
    // ---------- CONSTANTS ----------
    // -------------------------------
    public static final int N = 8;
    public static final int BLACK = -1;
    public static final int WHITE = 1;
    public static final int EMPTY = 0;

    // ----------------------------
    // ---------- FIELDS ----------
    // ----------------------------
    private int[][] board;

    // ---------------------------------
    // ---------- CONSTRUCTOR ----------
    // ---------------------------------
    public Reversi() {
        board = new int[N][N];
    }

    // --------------------------
    // ---------- MAIN ----------
    // --------------------------
    public static void main(String args[]) {}

    // -----------------------------
    // ---------- METHODS ----------
    // -----------------------------
    public void init() {
        board[4][4] = WHITE;
        board[3][3] = WHITE;
        board[4][3] = BLACK;
        board[3][4] = BLACK;
    }

    public boolean canPut(int x, int y, int val) {
        // x, y が番外
        if (x<0 || x>=N || y<0 || y>=N) return false;
        // EMPTY でなければ false
        if (board[y][x] != 0) return false;
        // val が {1, -1} でない
        if (val != 1 && val != -1) return false;
        int opp = -1 * val; // 相手の色

        // search 8 directions (FIXME: -1, 0, 1 が入っている前提)
        // method : 隣に異色があり、その先が同色である場合 false
        // REVIEW: 方向全てで統一的に描けるようにしたい、方向コードをつける感じ
        int i;
        // Upper Left
        i = 0;
        while (true) {
            i++;
            if (y-i<0 || x-i<0) break; // 端(盤外)判定
            if (i>1 && board[y-i][x-i] == val) return true; //
            if (board[y-i][x-i] != opp) break; // 隣は異色？
        }
        // Upper
        i = 0;
        while (true) {
            i++;
            if (y-i<0) break; // 端(盤外)判定
            if (i>1 && board[y-i][x] == val) return true; //
            if (board[y-i][x] != opp) break; // 隣は異色？
        }
        // Upper Right
        i = 0;
        while (true) {
            i++;
            if (y-i<0 || x+i>=N) break; // 端(盤外)判定
            if (i>1 && board[y-i][x+i] == val) return true; //
            if (board[y-i][x+i] != opp) break; // 隣は異色？
        }
        // Left
        i = 0;
        while (true) {
            i++;
            if (x-i<0) break; // 端(盤外)判定
            if (i>1 && board[y][x-i] == val) return true; //
            if (board[y][x-i] != opp) break; // 隣は異色？
        }
        // Right
        i = 0;
        while (true) {
            i++;
            if (x+i>=N) break; // 端(盤外)判定
            if (i>1 && board[y][x+i] == val) return true; //
            if (board[y][x+i] != opp) break; // 隣は異色？
        }
        // Lower Left
        i = 0;
        while (true) {
            i++;
            if (y+i>=N || x-i<0) break; // 端(盤外)判定
            if (i>1 && board[y+i][x-i] == val) return true; //
            if (board[y+i][x-i] != opp) break; // 隣は異色？
        }
        // Lower
        i = 0;
        while (true) {
            i++;
            if (y+i>=N) break; // 端(盤外)判定
            if (i>1 && board[y+i][x] == val) return true; //
            if (board[y+i][x] != opp) break; // 隣は異色？
        }
        // Lower Right
        i = 0;
        while (true) {
            i++;
            if (y+i>=N || x+i>=N) break; // 端(盤外)判定
            if (i>1 && board[y+i][x+i] == val) return true; //
            if (board[y+i][x+i] != opp) break; // 隣は異色？
        }
        return false;
    }

    // GETTER
    public int getBoardVal(int x, int y) {
        return this.board[y][x];
    }

    public int[][] getBoard() {
        return this.board;
    }

    // SETTER
    public void setBoardVal(int x, int y, int val) {
        if (val > 0) val = WHITE;
        else if (val < 0) val = BLACK;
        this.board[y][x] = val;
    }



}