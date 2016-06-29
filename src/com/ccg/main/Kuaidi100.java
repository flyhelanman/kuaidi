package com.ccg.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ccg.util.FileUtil;
import com.ccg.util.Kuaidi100Util;
import com.ccg.vo.KuaidiInfo;
import com.ccg.vo.KuaidiInfoVo;
import com.ccg.vo.KuaidiSource;

public class Kuaidi100 {

	private JFrame frmBy;
	private JTextField yundanField;
	private JLabel label;
	private JTextArea resultArea;
	private JLabel updateTimeLable;
	private JLabel updateTime;
	private JTextField remarkField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kuaidi100 window = new Kuaidi100();
					window.frmBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Kuaidi100() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBy = new JFrame();
		frmBy.setTitle("by:飞翔的荷兰人");
		frmBy.setBounds(100, 100, 826, 465);
		frmBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBy.getContentPane().setLayout(null);
		
		yundanField = new JTextField();
		yundanField.setBounds(395, 43, 246, 34);
		frmBy.getContentPane().add(yundanField);
		yundanField.setColumns(10);
		
		JButton searchButton = new JButton("查询");
		searchButton.setBounds(673, 43, 65, 34);
		frmBy.getContentPane().add(searchButton);
		
		JLabel yundanLabel = new JLabel("运单号");
		yundanLabel.setBounds(320, 52, 54, 15);
		frmBy.getContentPane().add(yundanLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 112, 545, 279);
		frmBy.getContentPane().add(scrollPane);
		
		resultArea = new JTextArea();
		scrollPane.setViewportView(resultArea);
		
		JLabel yundanTypeLable = new JLabel("运单类型");
		yundanTypeLable.setBounds(395, 87, 54, 15);
		frmBy.getContentPane().add(yundanTypeLable);
		
		label = new JLabel("");
		label.setBounds(459, 87, 93, 15);
		frmBy.getContentPane().add(label);
		
		updateTimeLable = new JLabel("更新时间");
		updateTimeLable.setBounds(579, 87, 54, 15);
		frmBy.getContentPane().add(updateTimeLable);
		
		updateTime = new JLabel("");
		updateTime.setBounds(595, 87, 150, 15);
		frmBy.getContentPane().add(updateTime);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 112, 235, 279);
		frmBy.getContentPane().add(scrollPane_1);
		
		final JTextArea textAreaLog = new JTextArea();
		scrollPane_1.setViewportView(textAreaLog);
		
		final String filePath = "d:/kuaidiLog.txt";
		//创建记录查询日志文件
		FileUtil.createFile(filePath);
		
		//获取指定目录下内容
		String oldContent = FileUtil.readTxtFile(filePath, "utf-8");
		textAreaLog.setText(oldContent);
		JLabel lblNewLabel = new JLabel("查询记录");
		lblNewLabel.setBounds(78, 87, 93, 15);
		frmBy.getContentPane().add(lblNewLabel);
		
		remarkField = new JTextField();
		remarkField.setBounds(10, 43, 98, 34);
		frmBy.getContentPane().add(remarkField);
		remarkField.setColumns(10);
		
		JButton addRemarkButton = new JButton("添加备注保存");
		addRemarkButton.setBounds(118, 43, 127, 34);
		frmBy.getContentPane().add(addRemarkButton);
		
		//点击查询触发事件
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String postId = yundanField.getText().trim();
				if("".equals(postId) || postId == null){
					resultArea.setText("");
					resultArea.setText("请输入运单号！");
					return;
				}
				KuaidiSource res = null;
				try {
					res = Kuaidi100Util.getKuaidiSource(postId);
					if(res.getAuto() == null || res.getAuto().size() == 0){
						resultArea.setText("");
						resultArea.setText("没有运单信息！");
						label.setText("");
						return;
					}
					String type = res.getAuto().get(0).getComCode(); //运单来源
					label.setText(type);
					KuaidiInfo kuaidiInfo = Kuaidi100Util.getKuaidiInfo(type, postId);
					if(!"".equals(kuaidiInfo.getUpdatetime())){
						updateTime.setText(kuaidiInfo.getUpdatetime());
					}
					List<KuaidiInfoVo> infoList = kuaidiInfo.getData();
					if(infoList == null){
						resultArea.setText("");
						resultArea.setText("没有运单信息！");
						label.setText("");
						return;
					}
					resultArea.setText("");
					for(KuaidiInfoVo temp : infoList){
						resultArea.append(temp.getTime()+"----"+temp.getContext());
						resultArea.append("\n");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//点击添加备注按钮触发事件
		addRemarkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String postId = yundanField.getText().trim();
				String remark = remarkField.getText().trim();  //备注信息
				String temp = FileUtil.readTxtFile(filePath, "utf-8");
				if(!temp.contains(postId)){
					//查询有记录则保存查询记录到txt ---- postId
					try {
						FileUtil.addTxt(filePath, postId+"----"+remark, "utf-8");
						temp = FileUtil.readTxtFile(filePath, "utf-8");
						textAreaLog.setText(temp);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
 