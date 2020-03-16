package test;

import java.awt.GridLayout;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import pojo.StudentInfo;
import service.Stuservice;
import service.Userservice;
import serviceImpl.StuserviceImpl;
import serviceImpl.UserserviceImpl;
import xr.BarChart;

public class Test {

	public static void printf()
	{
		System.out.print("\t");
	}
	public static int mainUI()
	{
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("\t*******�����ϱ�*******");
		System.out.print("\t����"+"\n");
		System.out.print("\t(1):��ѯȫ����Ϣ"+"\n"+
		"\t(2):���Ϣ"+"\n"+
		"\t(3):��ѯѧԺѧ����Ϣ\n"+
		"\t(4):�鿴����ѧԺ��ȷ�����"+
		"\n"+"\t(5):�˳�"+"\n");
		int n = in.nextInt();
		return n;
	}

	public static void queryAllInfo() {
		System.out.print("ѧԺ"+"\t"+
	"����"+"\t"+"ѧ��"+"\t"+"�绰"+"\t"+
	"ѧԺ�绰"+"\t"+"�Ƿ���"+"\t"+"�Ƿ������"+
	"\t"+"�Ƿ���ȷ�ϸ�Ⱦ"+"\t"+"�Ƿ�������������Ա����"+"\t");
		Userservice user = new UserserviceImpl();
		List<StudentInfo> list = user.GetStudetnInfo();
		for (StudentInfo stu1 : list) {
			System.out.print(stu1.getCollege());
			printf();
			System.out.print(stu1.getName());
			printf();
			System.out.print(stu1.getId());
			printf();
			System.out.print(stu1.getTel());
			printf();
			System.out.print(stu1.getTeachertel());
			printf();
			System.out.print(stu1.getFever());
			printf();
			System.out.print(stu1.getHubei());
			printf();
			System.out.print(stu1.getInfect());
			printf();
			System.out.print(stu1.getConWithHubei());
			printf();
			System.out.print("\n");
		}

	}
	
	public static void queryBycollege()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("����Ҫ��ѧԺ������:");
		String college = in.nextLine();
		StudentInfo stu = new StudentInfo();
		stu.setCollege(college);
		Userservice user = new UserserviceImpl();
		List <StudentInfo> list = user.GetStudetnInfoBycollege(stu);
		System.out.print("ѧԺ"+"\t"+
				"����"+"\t"+"ѧ��"+"\t"+"�绰"+"\t"+
				"ѧԺ�绰"+"\t"+"�Ƿ���"+"\t"+"�Ƿ������"+
				"\t"+"�Ƿ���ȷ�ϸ�Ⱦ"+"\t"+"�Ƿ�������������Ա����"+"\t"+"\n");
		for(StudentInfo stu1: list)
		{
			System.out.print(stu1.getCollege());
			printf();
			System.out.print(stu1.getName());
			printf();
			System.out.print(stu1.getId());
			printf();
			System.out.print(stu1.getTel());
			printf();
			System.out.print(stu1.getTeachertel());
			printf();
			System.out.print(stu1.getFever());
			printf();
			System.out.print(stu1.getHubei());
			printf();
			System.out.print(stu1.getInfect());
			printf();
			System.out.print(stu1.getConWithHubei());
			printf();
			System.out.print("\n");
		}
	}
	
	public static void add()
	{
		Stuservice stuservice = new StuserviceImpl();
		StudentInfo stu = new StudentInfo();
		Random random = new Random();
		String []college = {"�����","��ʷ","��ѧ","��ͳ","����","����","����","��ѧԺ","���Ժ","Ӣ��"};
		for(int i=0;i<=1000;i++)
		{
			int randomnumber = random.nextInt(9)+1;
			stu.setCollege(college[randomnumber]);
			stu.setName(String.valueOf((char)(0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)))));
			stu.setId(random.nextInt(3010110)+2010110);
			stu.setTel(String.valueOf(random.nextInt(10000)+100));
			stu.setTeachertel(String.valueOf(random.nextInt(10000)+100));
			stu.setFever(String.valueOf(random.nextInt(2)));
			stu.setHubei(String.valueOf(random.nextInt(2)));
			stu.setInfect(String.valueOf(random.nextInt(2)));
			stu.setConWithHubei(String.valueOf(random.nextInt(2)));
			
			stuservice.AddStu(stu);
		}
	}
	
	public static void addOneStudentInfo()
	{
		StudentInfo stuinfo = new StudentInfo();
		Stuservice stuservice = new StuserviceImpl();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("����ѧԺ��������ѧ�ţ��绰��ѧԺ�绰���Ƿ��ȣ��Ƿ���������Ƿ���ȷ�ϸ�Ⱦ���Ƿ�������������Ա����+\n");
		String college = in.next();
		String name = in.next();
		int id = in.nextInt();
		String tel = in.next();
		String teachertel = in.next();
		String fever = in.next();
		String hubei = in.next();
	    String infect = in.next();
	    String ConWithHubei= in.next();
	    
	    stuinfo.setCollege(college);
	    stuinfo.setName(name);
	    stuinfo.setId(id);
	    stuinfo.setTel(tel);
	    stuinfo.setTeachertel(teachertel);
	    stuinfo.setFever(fever);
	    stuinfo.setHubei(hubei);
	    stuinfo.setInfect(infect);
	    stuinfo.setConWithHubei(ConWithHubei);
	    
	    stuservice.AddStu(stuinfo);
	    System.out.println("��ӳɹ�");
		
	}
	
	public static void main(String[] args) {
		while(true)
		{
			int n = mainUI();
			if(n==1)
			{
				queryAllInfo();
			}
			if(n==2)
			{
				addOneStudentInfo();
			}
			if(n==3)
			{
				queryBycollege();
			}
			if(n==4)
			{
				JFrame frame = new JFrame("ͳ�Ʊ�");
				frame.setLayout(new GridLayout(3, 2, 10, 10));
				frame.add(new BarChart().getChartPanel()); // �������ͼ
				frame.setBounds(0, 0, 900, 800);
				frame.setVisible(true);
			}
			else
			{
				System.out.println("���������������");
			}
		}
	}

}
