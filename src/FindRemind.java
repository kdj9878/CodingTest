
public class FindRemind {

	/*
	 * �ڿ��� n�� �Ű������� �־����ϴ�. 
	 * n�� x�� ���� �������� 1�� �ǵ��� �ϴ� ���� ���� �ڿ��� x�� return �ϵ��� solution �Լ��� �ϼ����ּ���. 
	 * ���� �׻� �������� ����� �� �ֽ��ϴ�.
	 */
	public static void main(String[] args) {
		int n = 10;
		int answer = 0;
        boolean flag = true;
        int remind = 1;
        while(flag){
            if(n%remind != 1){
                remind++;
                continue;
            }
            flag = false;
        }
        answer = remind;
        System.out.printf("answer : %d", answer);
	}

}
