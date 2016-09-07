import java.util.Scanner;
import static java.lang.System.out;
/*
 *输入: 4545.454
 *输出:肆仟伍佰肆拾伍点肆伍肆
 */
public class number2Chinese {

	public static void main(String[] args) {
		String num,decimals="",theInteger="",result,finalResult;
		char temp;
		int i=0,j=0;
		Scanner sc = new Scanner(System.in);
		out.println("请输入一个数字.");
		num = sc.next(); //因为使用double类型小数点后的精度会丢失,所以使用字符串来输入数字.
		for(i=0;i<num.length();i++){ //16-24行用于处理整数部分,将整数部分保存到theInteger字符串中.
			temp = num.charAt(i);
			if(temp == '.'){
				break;
			}
			else{
				theInteger+=temp;
			}
		}
		i+=1;
		for(;i<num.length();i++){//26-29行用于处理小数部分,将小数部分保存到decimals字符串中.
			temp = num.charAt(i);
			decimals+=temp;
		}
		result = integerPart(theInteger);
		if(decimals.length()>0){
			finalResult = decimalPart(decimals,result);
			out.println(finalResult+"元");
		}
		else{
			out.println(result+"元");
		}
	}
	static String integerPart(String s){
		String result="",part1="",part2="",part3="";
		//part1用于处理小于一万的部分,part2用于处理大于等于一万小于一亿的部分,part3用于处理大于等于一亿部分.
		char temp,isZero='9';
		int count=0,char2int;
		String[] chineseNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String[] units = {"","拾","佰","仟"};
		int i=0,j=0;
		for(i=s.length()-1;i>=0;i--){//因为数分割是按每四位一次的,所以将整数部分字符串从后往前,每四位分割一次.
			temp = s.charAt(i);
			if(count>=0 && count<4){
				part1+=temp; //part1表示0-9999
			}
			else if(count>=4 && count<8){
				part2+=temp; //part2表示10000-99999999
			}
			else if(count>=8 && count<12){
				part3+=temp; //part3表示100000000-999999999999
			}
			count++;
		}
		if(part3.length()>0){//从最大的part3开始处理
			for(i=part3.length()-1;i>=0;i--){//因为在分割字符串时是从后往前分割,所以保存在part3的数字是倒序的.
				temp = part3.charAt(i); //用temp保存i位置的数字.
				char2int = temp-48;     //将temp对应的数字保存在char2int中.
				if(char2int != 0 ){
					result = result + chineseNum[char2int] + units[i];
				}
				else{
					if(i>0){  //如果i==0时,下面判断时会越界所以在这里加个判断语句.
						isZero = part3.charAt(i-1);//isZero判断是否出现连续的0;如果part3.charAt(i)==0 
												   //并且part3.charAt(i-1)==0,则下面的那个不会执行.
					}
					if(isZero != '0'){
						result = result + chineseNum[char2int];
					}
				}
			}
			result+="亿"; //等四个数字全部处理完后在result后加个"亿".
		}
		if(part2.length()>0){//同part3处理方法.
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
			result+="万"; 
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
		result+="点";
		char temp;
		int i=0,num2int;
		String[] chineseNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		for(i=0;i<s.length();i++){
			temp = s.charAt(i);
			num2int = temp-48;
			result+=chineseNum[num2int];
		}
		return result;
	}
}
