public class main {
    public static void main(String[] args) {
        SQLOperations op=new SQLOperations();
        op.insertData(12, "nadi", 27, "colombo");
        op.deleteData(7);
        op.updateData(8,"chamz",29, "galle");
        op.viewDetails();
    }
}
