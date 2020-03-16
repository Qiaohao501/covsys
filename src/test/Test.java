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
		System.out.println("\t*******疫情上报*******");
		System.out.print("\t输入"+"\n");
		System.out.print("\t(1):查询全部信息"+"\n"+
		"\t(2):填报信息"+"\n"+
		"\t(3):查询学院学生信息\n"+
		"\t(4):查看各个学院的确诊情况"+
		"\n"+"\t(5):退出"+"\n");
		int n = in.nextInt();
		return n;
	}

	public static void queryAllInfo() {
		System.out.print("学院"+"\t"+
	"姓名"+"\t"+"学号"+"\t"+"电话"+"\t"+
	"学院电话"+"\t"+"是否发热"+"\t"+"是否湖北籍"+
	"\t"+"是否已确认感染"+"\t"+"是否最近与湖北籍人员往来"+"\t");
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
		System.out.println("输入要查学院的名字:");
		String college = in.nextLine();
		StudentInfo stu = new StudentInfo();
		stu.setCollege(college);
		Userservice user = new UserserviceImpl();
		List <StudentInfo> list = user.GetStudetnInfoBycollege(stu);
		System.out.print("学院"+"\t"+
				"姓名"+"\t"+"学号"+"\t"+"电话"+"\t"+
				"学院电话"+"\t"+"是否发热"+"\t"+"是否湖北籍"+
				"\t"+"是否已确认感染"+"\t"+"是否最近与湖北籍人员往来"+"\t"+"\n");
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
		String []college = {"计算机","历史","化学","数统","生物","美术","体育","文学院","物电院","英语"};
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
		System.out.println("输入学院，姓名，学号，电话，学院电话，是否发热，是否湖北籍，是否已确认感染，是否最近与湖北籍人员往来+\n");
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
	    System.out.println("添加成功");
		
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
				JFrame frame = new JFrame("统计表");
				frame.setLayout(new GridLayout(3, 2, 10, 10));
				frame.add(new BarChart().getChartPanel()); // 添加柱形图
				frame.setBounds(0, 0, 900, 800);
				frame.setVisible(true);
			}
			else
			{
				System.out.println("输入错误，重新输入");
			}
		}
	}

}
