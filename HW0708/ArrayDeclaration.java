class ArrayDeclaration {
    public static void main(String[] args) {
        int[] scores;
        scores = new int[5];

        int[] grades = new int[5];

        int[] numbers = {85, 92, 77, 60, 88};

        int[] values = new int[] {10, 20, 30, 40, 50};

        System.out.println("scores 陣列長度: " + scores.length);
        System.out.println("grades 陣列長度: " + grades.length);
        System.out.println("numbers 陣列長度: " + numbers.length);
        System.out.println("values 陣列長度: " + values.length);
    }
}
