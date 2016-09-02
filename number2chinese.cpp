#include<iostream>
#include<map>
#include<fstream>
using namespace std;

map<int,string> m1;
string wei[4]{"","十","百","千"};; 
string cal(int num){
	string s="";
	int i=0,j=0,count=0;
	int singleNum[6];
	while(num>0){
		singleNum[i] = num%10;
		num/=10;
		count++;
		i++;
	}
	count--;
	if(count>=4){
		for(i=count;i>=4;i--){
			j=singleNum[i];
			if(j==1 && wei[i-4]=="十")
			{
				s = s+wei[i-4];
			} 
			else{
				s = s+m1[j]+wei[i-4];
			} 
		}
		s+="万"; 
		for(;i>=0;i--){
			j=singleNum[i];
			s = s+m1[j]+wei[i];
		}
	}
	else{
		for(i=count;i>=0;i--){
			j=singleNum[i];
			s = s+m1[j]+wei[i];
		}
	}
	return s;
}
int main(){
	ofstream file;
	file.open("caonima.csv");
	m1.insert(pair<int,string>(0,"零"));
	m1.insert(pair<int,string>(1,"一")); 
	m1.insert(pair<int,string>(2,"二"));
	m1.insert(pair<int,string>(3,"三"));
	m1.insert(pair<int,string>(4,"四"));
	m1.insert(pair<int,string>(5,"五"));
	m1.insert(pair<int,string>(6,"六"));
	m1.insert(pair<int,string>(7,"七"));
	m1.insert(pair<int,string>(8,"八"));
	m1.insert(pair<int,string>(9,"九"));
	string phrase;
	int
	times; 
	cout<<"请输入要重复的话:"<<endl;
	cin>>phrase; 
	cout<<"请输入重复次数:"<<endl;
	cin>>times; 
	for(int i=1;i<=times;i++)
	{
		string final = cal(i);
		file<<"第"<<final<<"遍:"<<phrase<<endl; 
	} 
	
	file.close();
}
