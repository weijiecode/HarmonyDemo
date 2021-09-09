package com.example.harmonydemo.slice;

import com.example.harmonydemo.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;


public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    Button btnLogin ;
    Button btnRegister ;
    Text text1 ;
    TextField username ;
    TextField password ;
    @Override
    public void onStart(Intent intent) {

        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        // 获取组件id
        btnLogin = (Button) findComponentById(ResourceTable.Id_btn1);
        btnRegister = (Button) findComponentById(ResourceTable.Id_btn_register);
        text1 = (Text) findComponentById(ResourceTable.Id_btn2);
        // 添加点击事件
        btnLogin.setClickedListener(this);
        btnRegister.setClickedListener(this);
        text1.setClickedListener(this);
        username = (TextField) findComponentById(ResourceTable.Id_username);
        password = (TextField) findComponentById(ResourceTable.Id_password);

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onClick(Component component) {
        String name = username.getText();
        String pwd = password.getText();
        ToastDialog td = new ToastDialog(this);
        td.setTransparent(true);
        td.setAlignment(LayoutAlignment.BOTTOM);
        td.setOffset(0,500);

        String u = "root";
        String p = "123456";
        if(component == btnLogin){
        if (name.equals(u) && pwd.equals(p)){
            // 点击按钮要执行的代码
                Intent i = new Intent();
                Operation operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withBundleName("com.example.harmonydemo")
                        .withAbilityName("com.example.harmonydemo.SecondAbility")
                        .build();
                i.setOperation(operation);
                startAbility(i);
                td.setText("登录成功！");
                td.show();

        }else {
            td.setText("账号或密码错误！");
            td.show();
        }
    }

        if(component != btnLogin){
            td.setText("该功能暂未开发！！！！！！");
            td.show();
        }


    }
}
