package com.xd.controller;

import com.xd.bean.Emp;
import com.xd.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 石莎莎
 * @create 2019-10-15 15:36
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("allEmp")
    public String list(Model model) {
        List<Emp> list = empService.findAll();
        System.out.println("list");
        model.addAttribute("list", list);
        return "allEmp";

    }

    @RequestMapping("toAddEmp")
    public String toAddEmp() {
        return "addEmp";
    }

    @RequestMapping("addEmp")
    public String addEmp(Emp emp,Model model) {
        empService.insertEmp(emp);
        return "redirect:/emp/allEmp";
    }

    @RequestMapping("del")
    public String deleteEmp(@Param(value = "empno") int empno) {
        empService.deleteEmp(empno);
        return "redirect:/emp/allEmp";
    }

    @RequestMapping("toUpdateEmp")
    public String toUpdateEmp(Model model, int empno) {
        model.addAttribute("emp", empService.findByOne(empno));
        return "updateEmp";
    }

    @RequestMapping("updateEmp")
    public String updateEmp(Model model, Emp emp) {
        empService.updateEmp(emp);
        emp = empService.findByOne(emp.getEmpno());
        model.addAttribute("emp", emp);
        return "redirect:/emp/allEmp";
    }

    @RequestMapping("findEmpByNo")
    public String findByOneEmp(Model model, int empno) {
        model.addAttribute("emp", empService.findByOne(empno));
        return "find";

    }


    @Autowired
    private JavaMailSenderImpl sender;

    @RequestMapping("sendMail")
    //@ResponseBody返回的为body内的文本串
    public  String  sendMail(MultipartFile mf){
        System.out.println("寄来了");
        System.out.println("????????"+mf.getOriginalFilename());
        try {
            //创建邮件
            MimeMessage message = sender.createMimeMessage();
            //true 代表附件
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("15891046712@163.com");
            helper.setTo("1539702361@qq.com");
            helper.setSubject("测试邮件");
            helper.setText("这是一封测试邮件。。。。。。。。。。。。。。。。");
            helper.setSentDate(new Date());
            //添加附件
            helper.addAttachment(mf.getOriginalFilename(),mf);
            //发送邮件
            sender.send(message);
            System.out.println("成功");
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("upload")
    //@ResponseBody
    public String  upload(@RequestParam("upload") MultipartFile mf, HttpServletRequest req){
        System.out.println("进来了");
        //获取文件名称
        String fileName = null;

        fileName = UUID.randomUUID().toString().replace("-","")+ "_"+ mf.getOriginalFilename();
        System.out.println("-----------"+fileName);
        //存储文件的路径
        String path = req.getSession().getServletContext().getRealPath("upload/");
        System.out.println("-----------"+path);

        File file = new File(path, fileName);
        try {
            //进行文件上传
            mf.transferTo(file);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }


}
