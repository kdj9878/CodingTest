
public class needMoney {

	public static void main(String[] args) {
//		���� ���� ���̱ⱸ�� �αⰡ �ſ� ���� ���� ������ �ʽ��ϴ�. �� ���̱ⱸ�� ���� �̿��� price�� �ε�, ���̱ⱸ�� N �� ° �̿��Ѵٸ� ���� �̿���� N�踦 �ޱ�� �Ͽ����ϴ�. 
//		��, ó�� �̿�ᰡ 100�̾��ٸ� 2��°���� 200, 3��°���� 300���� ����� �λ�˴ϴ�.
//		���̱ⱸ�� count�� Ÿ�� �Ǹ� ���� �ڽ��� ������ �ִ� �ݾ׿��� �󸶰� ���ڶ������ return �ϵ��� solution �Լ��� �ϼ��ϼ���.
//		��, �ݾ��� �������� ������ 0�� return �ϼ���.
				
		int price = 3;
		int money = 20;
		int count = 4;
		long answer = -1;
		
		long sum = 0;   // ������ �� �ݾ�
        for(int i = 1; i <= count; i++){
            sum += price*i;
        }
        answer = sum - money;
        if(answer < 0){ // ������ �ִ� ���� �� ���� ���
            answer = 0;
        }
	}

}
