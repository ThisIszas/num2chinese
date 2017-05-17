#include<iostream>
#include<string>
using namespace std;

int main()
{
    string str_number = "";
    int i = 0,j = 0;
    cout<<"请输入数字.\n";
    cin>>str_number;
    string result="", part1="", part2="", part3="";
    char temp, isZero='9';
    int count=0, char2int=0;
    string chineseNum[10] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    string units[4] = {"","拾","佰","仟"};
    for (i = str_number.length() - 1; i >= 0; i--)
    {
        temp = str_number[i];
        if(count>=0 && count<4)
        {
				part1+=temp; //part1表示0-9999
		}
		else if(count>=4 && count<8)
        {
			part2+=temp; //part2表示10000-99999999
		}
		else if(count>=8 && count<12)
        {
			part3+=temp; //part3表示100000000-999999999999
		}
		count++;
    }
    // cout<<part1<<" "<<part2<<" "<<part3<<endl;
    if(part3.length()>0)
    {//从最大的part3开始处理
		for(i=part3.length()-1;i>=0;i--)
        {//因为在分割字符串时是从后往前分割,所以保存在part3的数字是倒序的.
			temp = part3[i]; //用temp保存i位置的数字.
			char2int = temp-48;     //将temp对应的数字保存在char2int中.
			if(char2int != 0 )
            {
				result = result + chineseNum[char2int] + units[i];
			}
			else
            {
				if(i>0)
                {  //如果i==0时,下面判断时会越界所以在这里加个判断语句.
					isZero = part3[i-1];//isZero判断是否出现连续的0;如果part3.charAt(i)==0
												   //并且part3.charAt(i-1)==0,则下面的那个不会执行.
				}
				if(isZero != '0')
                {
					result = result + chineseNum[char2int];
				}
			}
		}
		result+="亿"; //等四个数字全部处理完后在result后加个"亿".
	}
	if(part2.length()>0)
	{//同part3处理方法.
		for(i=part2.length()-1;i>=0;i--)
		{
			temp = part2[i];
			char2int = temp-48;
			if(char2int != 0 )
			{
				result = result + chineseNum[char2int] + units[i];
			}
			else
			{
				if(i>0)
				{
					isZero = part2[i-1];
				}
				if(isZero != '0')
				{
					result = result + chineseNum[char2int];
				}
			}
		}
		result+="万"; 
	}
	if(part1.length()>0)
	{
		for(i=part1.length()-1;i>=0;i--)
		{
			temp = part1[i];
			char2int = temp-48;
			if(char2int != 0 )
			{
				result = result + chineseNum[char2int] + units[i];
			}
			else
			{
				if(i>0)
				{
					isZero = part1[i-1];
				}
				if(isZero != '0')
				{
					result = result + chineseNum[char2int];
				}
			}
		}
	}
    cout<<result<<endl;
}

