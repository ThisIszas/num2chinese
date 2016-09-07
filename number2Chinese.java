import java.util.Scanner;
import static java.lang.System.out;
/*
 *����: 4545.454
 *���:��Ǫ�����ʰ���������
 */
public class number2Chinese {

	public static void main(String[] args) {
		String num,decimals="",theInteger="",result,finalResult;
		char temp;
		int i=0,j=0;
		Scanner sc = new Scanner(System.in);
		out.println("������һ������.");
		num = sc.next(); //��Ϊʹ��double����С�����ľ��Ȼᶪʧ,����ʹ���ַ�������������.
		for(i=0;i<num.length();i++){ //16-24�����ڴ�����������,���������ֱ��浽theInteger�ַ�����.
			temp = num.charAt(i);
			if(temp == '.'){
				break;
			}
			else{
				theInteger+=temp;
			}
		}
		i+=1;
		for(;i<num.length();i++){//26-29�����ڴ���С������,��С�����ֱ��浽decimals�ַ�����.
			temp = num.charAt(i);
			decimals+=temp;
		}
		result = integerPart(theInteger);
		if(decimals.length()>0){
			finalResult = decimalPart(decimals,result);
			out.println(finalResult+"Ԫ");
		}
		else{
			out.println(result+"Ԫ");
		}
	}
	static String integerPart(String s){
		String result="",part1="",part2="",part3="";
		//part1���ڴ���С��һ��Ĳ���,part2���ڴ�����ڵ���һ��С��һ�ڵĲ���,part3���ڴ�����ڵ���һ�ڲ���.
		char temp,isZero='9';
		int count=0,char2int;
		String[] chineseNum = {"��","Ҽ","��","��","��","��","½","��","��","��"};
		String[] units = {"","ʰ","��","Ǫ"};
		int i=0,j=0;
		for(i=s.length()-1;i>=0;i--){//��Ϊ���ָ��ǰ�ÿ��λһ�ε�,���Խ����������ַ����Ӻ���ǰ,ÿ��λ�ָ�һ��.
			temp = s.charAt(i);
			if(count>=0 && count<4){
				part1+=temp; //part1��ʾ0-9999
			}
			else if(count>=4 && count<8){
				part2+=temp; //part2��ʾ10000-99999999
			}
			else if(count>=8 && count<12){
				part3+=temp; //part3��ʾ100000000-999999999999
			}
			count++;
		}
		if(part3.length()>0){//������part3��ʼ����
			for(i=part3.length()-1;i>=0;i--){//��Ϊ�ڷָ��ַ���ʱ�ǴӺ���ǰ�ָ�,���Ա�����part3�������ǵ����.
				temp = part3.charAt(i); //��temp����iλ�õ�����.
				char2int = temp-48;     //��temp��Ӧ�����ֱ�����char2int��.
				if(char2int != 0 ){
					result = result + chineseNum[char2int] + units[i];
				}
				else{
					if(i>0){  //���i==0ʱ,�����ж�ʱ��Խ������������Ӹ��ж����.
						isZero = part3.charAt(i-1);//isZero�ж��Ƿ����������0;���part3.charAt(i)==0 
												   //����part3.charAt(i-1)==0,��������Ǹ�����ִ��.
					}
					if(isZero != '0'){
						result = result + chineseNum[char2int];
					}
				}
			}
			result+="��"; //���ĸ�����ȫ�����������result��Ӹ�"��".
		}
		if(part2.length()>0){//ͬpart3������.
			for(i=part2.length()-1;i>=0;i--){
				temp = part2.charAt(i);
				char2int = temp-48;
				if(char2int != 0 ){
					result = result + chineseNum[char2int] + units[i];
				}
				else{
					if(i>0){
						isZero = part2.charAt(i-1);
					}
					if(isZero != '0'){
						result = result + chineseNum[char2int];
					}
				}
			}
			result+="��"; 
		}
		if(part1.length()>0){
			for(i=part1.length()-1;i>=0;i--){
				temp = part1.charAt(i);
				char2int = temp-48;
				if(char2int != 0 ){
					result = result + chineseNum[char2int] + units[i];
				}
				else{
					if(i>0){
						isZero = part1.charAt(i-1);
					}
					if(isZero != '0'){
						result = result + chineseNum[char2int];
					}
				}
			}
		}
		return result;
	}
	static String decimalPart(String s,String result){
		result+="��";
		char temp;
		int i=0,num2int;
		String[] chineseNum = {"��","Ҽ","��","��","��","��","½","��","��","��"};
		for(i=0;i<s.length();i++){
			temp = s.charAt(i);
			num2int = temp-48;
			result+=chineseNum[num2int];
		}
		return result;
	}
}
