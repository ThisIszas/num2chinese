#include<iostream>
#include<string>
using namespace std;

int main()
{
    string str_number = "";
    int i = 0,j = 0;
    cout<<"����������.\n";
    cin>>str_number;
    string result="", part1="", part2="", part3="";
    char temp, isZero='9';
    int count=0, char2int=0;
    string chineseNum[10] = {"��","Ҽ","��","��","��","��","½","��","��","��"};
    string units[4] = {"","ʰ","��","Ǫ"};
    for (i = str_number.length() - 1; i >= 0; i--)
    {
        temp = str_number[i];
        if(count>=0 && count<4)
        {
				part1+=temp; //part1��ʾ0-9999
		}
		else if(count>=4 && count<8)
        {
			part2+=temp; //part2��ʾ10000-99999999
		}
		else if(count>=8 && count<12)
        {
			part3+=temp; //part3��ʾ100000000-999999999999
		}
		count++;
    }
    // cout<<part1<<" "<<part2<<" "<<part3<<endl;
    if(part3.length()>0)
    {//������part3��ʼ����
		for(i=part3.length()-1;i>=0;i--)
        {//��Ϊ�ڷָ��ַ���ʱ�ǴӺ���ǰ�ָ�,���Ա�����part3�������ǵ����.
			temp = part3[i]; //��temp����iλ�õ�����.
			char2int = temp-48;     //��temp��Ӧ�����ֱ�����char2int��.
			if(char2int != 0 )
            {
				result = result + chineseNum[char2int] + units[i];
			}
			else
            {
				if(i>0)
                {  //���i==0ʱ,�����ж�ʱ��Խ������������Ӹ��ж����.
					isZero = part3[i-1];//isZero�ж��Ƿ����������0;���part3.charAt(i)==0
												   //����part3.charAt(i-1)==0,��������Ǹ�����ִ��.
				}
				if(isZero != '0')
                {
					result = result + chineseNum[char2int];
				}
			}
		}
		result+="��"; //���ĸ�����ȫ�����������result��Ӹ�"��".
	}
	if(part2.length()>0)
	{//ͬpart3������.
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
		result+="��"; 
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

