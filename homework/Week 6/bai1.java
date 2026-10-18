static void partition(int[] ar) {
    int pivot = ar[0];
    List<Integer> left = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    
    for (int i = 0; i < ar.length; i++) {
        if (ar[i] < pivot) {
            left.add(ar[i]);
        } else if (ar[i] == pivot) {
            equal.add(ar[i]);
        } else {
            right.add(ar[i]);
        }
    }
    
    // Gộp lại vào mảng ban đầu hoặc in trực tiếp
    int index = 0;
    for (int num : left) ar[index++] = num;
    for (int num : equal) ar[index++] = num;
    for (int num : right) ar[index++] = num;
    
    printArray(ar);
}