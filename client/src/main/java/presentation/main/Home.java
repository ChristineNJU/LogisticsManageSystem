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
		modifyPassword.setBounds(220,250,100,30);
		modifyPassword.setFont(FontSet.twenty);
		oldPass.setBounds(220,300,120,30);
		newPass.setBounds(220,330,120,30);
		newPassConfirm.setBounds(220,360,120,30);
		oldPassword.setBounds(350,300,120,28);
		newPassword.setBounds(350,330,120,28);
		newPasswordConfirm.setBounds(350,360,120,28);
		confirm.setLocation(220,390);
		
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
	}

	private void confirmRevise(){
		this.remove(error);
		String oldP = oldPassword.getPassword().toString();
		String newP = newPassword.getPassword().toString();
		String newPC = newPasswordConfirm.getPassword().toString();
		
		if(newP.equals(newPC)){
			ResetState state = service.reset(user.getId(), oldP, newP);
			if(state == ResetState.WRONGPW){
				showError("原密码错误");
			}else if(state == ResetState.SUCCESS){
				showError("修改成功");
				MainFrame.changeContentPanel(new Home(this.user));
			}
		}else{
			showError("两次输入的新密码不一样");
		}
	}
	
	private void showError(String s){
		error = new LabelError(s);
		error.setBounds(220,200,400,30);
		this.add(error);
	}
	
}