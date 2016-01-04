package presentation.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

import State.ResetState;
import VO.UserVO;
import businesslogic.Impl.User.ResetPasswordImpl;
import businesslogic.Service.User.ResetPasswordService;
import presentation.components.ButtonOk;
import presentation.components.LabelError;
import presentation.components.LabelHeader;
import presentation.components.PanelContent;
import presentation.frame.MainFrame;

public class Home extends PanelContent{

	UserVO user;
	
	LabelHeader info = new LabelHeader("个人信息");
	LabelHeader id;
	LabelHeader name;
	LabelHeader staffType;
	
	LabelHeader modifyPassword = new LabelHeader("修改密码");
	LabelHeader oldPass = new LabelHeader("原有密码  ：");
	LabelHeader newPass = new LabelHeader("新  密  码：");
	LabelHeader newPassConfirm = new LabelHeader("新密码确认：");
	JPasswordField oldPassword = new JPasswordField();
	JPasswordField newPassword = new JPasswordField();
	JPasswordField newPasswordConfirm = new JPasswordField();
	
	ButtonOk confirm = new ButtonOk("确认修改");
	
	ResetPasswordService service = new ResetPasswordImpl();
	
	LabelError error = new LabelError("");
	public Home(String s) {
		super(s);
	}
	
	public Home(UserVO user){
		this("个人首页");
		this.user = user;
		
		id = new LabelHeader("工号: "+user.getId());
		name = new LabelHeader("姓名: "+user.getName());
		staffType = new LabelHeader("身份: "+Translater.getChineseForUserRole(user.getRole()));
		
		info.setBounds(116,150,200,50);
		info.setFont(FontSet.twenty_five);
		id.setBounds(116, 205, 200, 30);
		name.setBounds(116, 240, 200, 30);
		staffType.setBounds(116, 275, 200, 30);
		
		modifyPassword.setBounds(116,350,200,50);
		modifyPassword.setFont(FontSet.twenty_five);
		oldPass.setBounds(116,420,120,30);
		newPass.setBounds(116,450,120,30);
		newPassConfirm.setBounds(116,480,120,30);
		oldPassword.setBounds(236,420,120,28);
		newPassword.setBounds(236,450,120,28);
		newPasswordConfirm.setBounds(236,480,120,28);
		confirm.setLocation(116,530);
		
		confirm.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmRevise();
			}
		});
		
		this.add(modifyPassword);
		this.add(oldPass);
		this.add(newPass);
		this.add(newPassConfirm);
		this.add(oldPassword);
		this.add(newPassword);
		this.add(newPasswordConfirm);
		this.add(confirm);
		
		this.add(info);
		this.add(id);
		this.add(name);
		this.add(staffType);
	}

	private void confirmRevise(){
		this.remove(error);
		String oldP = oldPassword.getText();
		String newP = newPassword.getText();
		String newPC = newPasswordConfirm.getText();
		
		System.out.println(newP+" "+newPC);
		if(newP.equals(newPC)){
			
			ResetState state = service.reset(user.getId(), oldP, newP);
			if(state == ResetState.WRONGPW){
				showError("原密码错误");
			}else if(state == ResetState.SUCCESS){
				showError("修改成功");
//				MainFrame.changeContentPanel(new Home(this.user));
			}
		}else{
			showError("两次输入的新密码不一样");
		}
	}
	
	private void showError(String s){
		error = new LabelError(s);
		error.setBounds(420,530,400,30);
		this.add(error);
		this.repaint();
	}
	
}
