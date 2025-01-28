class pattern
{
public static void main(String args[])
{
int n =5;
for(int i=0;i<n;i++)
{
if(i<n/2){
for(int j=1;j<(n-i)/2;j++)
System.out.print(" ");
for(int j=1;j<2*i+1;j++)
System.out.print("*");
}
else
{
for(int j=n;j>i-1;j--)
System.out.print(" ");
for(int j=1;j<2*(n-i-1)+1;j++)
System.out.print("*");
}
System.out.println();
}
}
}
