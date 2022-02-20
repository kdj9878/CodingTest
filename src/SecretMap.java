// 2018 KAKAO BLIND RECRUITMENT
public class SecretMap {

	public String[] Solution(int n, int[] arr1, int[] arr2) {
		
		String[] answer = new String[n];
        char[] charArray = new char[n];
        char[] charArray2 = new char[n];
        
        for(int i = 0; i < n; i++){
            // 10진수를 2진수로 변환
            String binary = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            
            // 2진수 문자열의 길이가 n보다 작을 경우 앞에 0을 채워줌
            if(binary.length() < n){
                while(binary.length() < n){
                    binary = 0 + binary;
                }
            };
            if(binary2.length() < n){
                while(binary2.length() < n){
                    binary2 = 0 + binary2;
                }
            };
            
            // char[] 로 변환
            charArray = binary.toCharArray();
            charArray2 = binary2.toCharArray();
            
            // 각각의 인덱스를 더함
            String tempString = "";
            for(int j = 0; j < n; j++){
                tempString += String.valueOf(Character.getNumericValue(charArray[j]) + Character.getNumericValue(charArray2[j]));
            }
            
            // 더한 값이 2인 경우 1로
            answer[i] = tempString.replaceAll("2", "1");
        }
        
        // 최종 
        for(int j = 0; j < answer.length; j++){
            answer[j] = answer[j].replaceAll("1", "#");
            answer[j] = answer[j].replaceAll("0", " ");
        }

        return answer;
	}

}
