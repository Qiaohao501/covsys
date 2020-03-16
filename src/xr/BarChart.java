package xr;//������������������Լ������İ������Խ����޸�

import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import pojo.StudentInfo;
import service.Userservice;
import serviceImpl.UserserviceImpl;

public class BarChart {
	ChartPanel frame1;

	public BarChart() {
		CategoryDataset dataset = getDataSet();// ����õ����ݴ��ݸ�CategoryDataset��Ķ���
		JFreeChart chart = ChartFactory.createBarChart3D("ͳ�Ʊ�", // ͼ�����
				"ѧԺ", // Ŀ¼�����ʾ��ǩ
				"��������", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
		);

		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		CategoryAxis domainAxis = plot.getDomainAxis(); // ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 12)); // ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12)); // ��ֱ����
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����", Font.BOLD, 15));// ���ñ�������

		frame1 = new ChartPanel(chart, true); // ����Ҳ������chartFrame,����ֱ������һ��������Frame

	}

	public CategoryDataset getDataSet() {

		String[] college = { "�����", "��ʷ", "��ѧ", "��ͳ", "����", "����", "����", "��ѧԺ", "���Ժ", "Ӣ��" };
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		StudentInfo stu = new StudentInfo();
		Userservice user = new UserserviceImpl();

		for (int i = 0; i <= 9; i++) {
			stu.setCollege(college[i]);
			stu.setInfect("0");
			int count = user.GetStudetnInfoBycollegeAndInfect(stu);
			dataset.addValue(count, college[i], "");// �ɼ�1
		}
		dataset.addValue(100, "�����", "");// �ɼ�1
		dataset.addValue(95, "��ʷ", "");// �ɼ�2
		dataset.addValue(80, "��ѧ", "");// �ɼ�3
		dataset.addValue(110, "��ͳ", "");// �ɼ�4
		return dataset;
	}

	public ChartPanel getChartPanel() {
		return frame1;

	}
/*
	public static void main(String args[]) {
		JFrame frame = new JFrame("�ɼ���");
		frame.setLayout(new GridLayout(3, 2, 10, 10));
		frame.add(new BarChart().getChartPanel()); // �������ͼ
		frame.setBounds(0, 0, 900, 800);
		frame.setVisible(true);
	}*/
}
