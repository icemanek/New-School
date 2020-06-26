package com.motorcycleschool.school.util;

import com.motorcycleschool.school.config.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties("spring.mail")
public class EmailSender {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.auth}")
    private String auth;

    @Value("${spring.mail.startTls}")
    private String startTls;


    Properties props = new Properties();

    public void sendResetPasswordMail(String to, String link) {

        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", startTls);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Resetowanie hasła");

           String file = "../../resources/static/EmailTemplates/resetPasswordEmail.html";
            message.setContent(file, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email resetowania hasła wysłany");

        } catch (MessagingException e) {


            throw new RuntimeException(e);
        }
    }


    public void sendRegistrationMail(String to, String body) {

        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", startTls);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );


        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Rejestracja konta");

            String file2 = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional //EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>" +
                    "" +
                    "<html xmlns='http://www.w3.org/1999/xhtml' xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:v='urn:schemas-microsoft-com:vml'>" +
                    "<head>" +
                    "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->" +
                    "<meta content='text/html; charset=utf-8' http-equiv='Content-Type'/>" +
                    "<meta content='width=device-width' name='viewport'/>" +
                    "<!--[if !mso]><!-->" +
                    "<meta content='IE=edge' http-equiv='X-UA-Compatible'/>" +
                    "<!--<![endif]-->" +
                    "<title></title>" +
                    "<!--[if !mso]><!-->" +
                    "<!--<![endif]-->" +
                    "<style type='text/css'>" +
                    "body {" +
                    "margin: 0;" +
                    "padding: 0;" +
                    "}" +
                    "Book In-App" +
                    "table," +
                    "td," +
                    "tr {" +
                    "vertical-align: top;" +
                    "border-collapse: collapse;" +
                    "}" +
                    "" +
                    "* {" +
                    "line-height: inherit;" +
                    "}" +
                    "" +
                    "a[x-apple-data-detectors=true] {" +
                    "color: inherit !important;" +
                    "text-decoration: none !important;" +
                    "}" +
                    "</style>" +
                    "<style id='media-query' type='text/css'>" +
                    "@media (max-width: 660px) {" +
                    "" +
                    ".block-grid," +
                    ".col {" +
                    "min-width: 320px !important;" +
                    "max-width: 100% !important;" +
                    "display: block !important;" +
                    "}" +
                    "" +
                    ".block-grid {" +
                    "width: 100% !important;" +
                    "}" +
                    "" +
                    ".col {" +
                    "width: 100% !important;" +
                    "}" +
                    "" +
                    ".col>div {" +
                    "margin: 0 auto;" +
                    "}" +
                    "" +
                    "img.fullwidth," +
                    "img.fullwidthOnMobile {" +
                    "max-width: 100% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col {" +
                    "min-width: 0 !important;" +
                    "display: table-cell !important;" +
                    "}" +
                    "" +
                    ".no-stack.two-up .col {" +
                    "width: 50% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num4 {" +
                    "width: 33% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num8 {" +
                    "width: 66% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num4 {" +
                    "width: 33% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num3 {" +
                    "width: 25% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num6 {" +
                    "width: 50% !important;" +
                    "}" +
                    "" +
                    ".no-stack .col.num9 {" +
                    "width: 75% !important;" +
                    "}" +
                    "" +
                    ".video-block {" +
                    "max-width: none !important;" +
                    "}" +
                    "" +
                    ".mobile_hide {" +
                    "min-height: 0px;" +
                    "max-height: 0px;" +
                    "max-width: 0px;" +
                    "display: none;" +
                    "overflow: hidden;" +
                    "font-size: 0px;" +
                    "}" +
                    "" +
                    ".desktop_hide {" +
                    "display: block !important;" +
                    "max-height: none !important;" +
                    "}" +
                    "}" +
                    "</style>" +
                    "</head>" +
                    "<body class='clean-body' style='margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;'>" +
                    "<!--[if IE]><div class='ie-browser'><![endif]-->" +
                    "<table bgcolor='#FFFFFF' cellpadding='0' cellspacing='0' class='nl-container' role='presentation' style='table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td style='word-break: break-word; vertical-align: top;' valign='top'>" +
                    "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td align='center' style='background-color:#FFFFFF'><![endif]-->" +
                    "<div style='background-color:#0A0A0A;'>" +
                    "<div class='block-grid' style='Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #0A0A0A;'>" +
                    "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#0A0A0A;'>" +
                    "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:#0A0A0A;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:640px'><tr class='layout-full-width' style='background-color:#0A0A0A'><![endif]-->" +
                    "<!--[if (mso)|(IE)]><td align='center' width='640' style='background-color:#0A0A0A;width:640px; border-top: 3px solid #BF3100; border-left: 0px solid #BF3100; border-bottom: 0px solid #BF3100; border-right: 0px solid #BF3100;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:20px;'><![endif]-->" +
                    "<div class='col num12' style='min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;'>" +
                    "<div style='width:100% !important;'>" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "<div style='border-top:3px solid #BF3100; border-left:0px solid #BF3100; border-bottom:0px solid #BF3100; border-right:0px solid #BF3100; padding-top:20px; padding-bottom:20px; padding-right: 0px; padding-left: 0px;'>" +
                    "<!--<![endif]-->" +
                    "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif'><![endif]-->" +
                    "<div style='color:#555555;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>" +
                    "<div style='font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 12px; line-height: 1.2; color: #555555; mso-line-height-alt: 14px;'>" +
                    "<p style='font-size: 22px; line-height: 1.2; text-align: center; mso-line-height-alt: 26px; margin: 0;'><span style='font-size: 22px; color: #ff9900;'><strong>Motorcycle School</strong></span></p>" +
                    "</div>" +
                    "</div>" +
                    "<!--[if mso]></td></tr></table><![endif]-->" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "</div>" +
                    "<!--<![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "<div style='background-color:#000;'>" +
                    "<div class='block-grid' style='Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;'>" +
                    "<div style='border-collapse: collapse;display: table;width: 100%;background-color:transparent;'>" +
                    "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:#000;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:640px'><tr class='layout-full-width' style='background-color:transparent'><![endif]-->" +
                    "<!--[if (mso)|(IE)]><td align='center' width='640' style='background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;'><![endif]-->" +
                    "<div class='col num12' style='min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;'>" +
                    "<div style='width:100% !important;'>" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;'>" +
                    "<!--<![endif]-->" +
                    "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;' valign='top'>" +
                    "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='50' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 50px; width: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td height='50' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;' valign='top'>" +
                    "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='35' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td height='35' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif'><![endif]-->" +
                    "<div style='color:#555555;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>" +
                    "<div style='font-size: 16px; line-height: 1.2; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #555555; mso-line-height-alt: 19px;'>" +
                    "<p style='font-size: 20px; line-height: 1.2; text-align: center; mso-line-height-alt: 24px; margin: 0;'><span style='color: #999999; font-size: 20px;'><strong>Create account mail</strong></span></p>" +
                    "</div>" +
                    "</div>" +
                    "<!--[if mso]></td></tr></table><![endif]-->" +
                    "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top: 0px; padding-bottom: 5px; font-family: Arial, sans-serif'><![endif]-->" +
                    "<div style='color:#555555;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.2;padding-top:0px;padding-right:0px;padding-bottom:5px;padding-left:0px;'>" +
                    "<div style='font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 12px; line-height: 1.2; color: #555555; mso-line-height-alt: 14px;'>" +
                    "<p style='font-size: 46px; line-height: 1.2; text-align: center; mso-line-height-alt: 55px; margin: 0;'><span style='font-size: 46px; color: #ffffff;'><strong>Joker - The Origins</strong></span></p>" +
                    "</div>" +
                    "</div>" +
                    "<!--[if mso]></td></tr></table><![endif]-->" +
                    "<div align='center' class='button-container' style='padding-top:15px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>" +
                    "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;'><tr><td style='padding-top: 15px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px' align='center'><v:roundrect xmlns:v='urn:schemas-microsoft-com:vml' xmlns:w='urn:schemas-microsoft-com:office:word' href='localhost:4200' style='height:39pt; width:166.5pt; v-text-anchor:middle;' arcsize='8%' stroke='false' fillcolor='#BF3100'><w:anchorlock/><v:textbox inset='0,0,0,0'><center style='color:#ffffff; font-family:Arial, sans-serif; font-size:16px'><![endif]--><a href='http://localhost:4200/home' style='-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #BF3100; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #BF3100; border-right: 1px solid #BF3100; border-bottom: 1px solid #BF3100; border-left: 1px solid #BF3100; padding-top: 10px; padding-bottom: 10px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;' target='_blank'><span style='padding-left:60px;padding-right:60px;font-size:16px;display:inline-block;'>" +
                    "<span style='font-size: 16px; line-height: 2; mso-line-height-alt: 32px;'><strong>Book In-App</strong></span>" +
                    "</span></a>" +
                    "<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->" +
                    "</div>" +
                    "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px;' valign='top'>" +
                    "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='55' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 55px; width: 100%;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td height='55' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "</div>" +
                    "<!--<![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "<div style='background-color:#fff;'>" +
                    "<div class='block-grid' style='Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;'>" +
                    "<div style='border-collapse: collapse;display: table;width: 100%;background-color:transparent;'>" +
                    "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:#fff;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:640px'><tr class='layout-full-width' style='background-color:transparent'><![endif]-->" +
                    "<!--[if (mso)|(IE)]><td align='center' width='640' style='background-color:transparent;width:640px; border-top: 0px solid #BF3100; border-left: 0px solid #BF3100; border-bottom: 3px solid #BF3100; border-right: 0px solid #BF3100;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:40px; padding-bottom:25px;'><![endif]-->" +
                    "<div class='col num12' style='min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;'>" +
                    "<div style='width:100% !important;'>" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "<div style='border-top:0px solid #BF3100; border-left:0px solid #BF3100; border-bottom:3px solid #BF3100; border-right:0px solid #BF3100; padding-top:40px; padding-bottom:25px; padding-right: 0px; padding-left: 0px;'>" +
                    "<!--<![endif]-->" +
                    "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 20px; padding-bottom: 15px; font-family: Arial, sans-serif'><![endif]-->" +
                    "<div style='color:#555555;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.2;padding-top:20px;padding-right:10px;padding-bottom:15px;padding-left:10px;'>" +
                    "<div style='font-size: 14px; line-height: 1.2; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #555555; mso-line-height-alt: 17px;'>" +
                    "<p style='font-size: 14px; line-height: 1.2; text-align: center; mso-line-height-alt: 17px; margin: 0;'><span style='color: #808080; font-size: 14px;'>© Movie Stars Copyright 2020</span></p>" +
                    "</div>" +
                    "</div>" +
                    "<!--[if mso]></td></tr></table><![endif]-->" +
                    "<table cellpadding='0' cellspacing='0' class='social_icons' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;' valign='top' width='100%'>" +
                    "<tbody>" +
                    "<tr style='vertical-align: top;' valign='top'>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;' valign='top'>" +
                    "<table activate='activate' align='center' alignment='alignment' cellpadding='0' cellspacing='0' class='social_table' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: undefined; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;' to='to' valign='top'>" +
                    "<tbody>" +
                    "<tr align='center' style='vertical-align: top; display: inline-block; text-align: center;' valign='top'>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;' valign='top'><a href='https://www.facebook.com/' target='_blank'><img alt='Facebook' height='32' src='images/facebook@2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;' title='Facebook' width='32'/></a></td>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;' valign='top'><a href='https://twitter.com/' target='_blank'><img alt='Twitter' height='32' src='images/twitter@2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;' title='Twitter' width='32'/></a></td>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;' valign='top'><a href='https://instagram.com/' target='_blank'><img alt='Instagram' height='32' src='images/instagram@2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;' title='Instagram' width='32'/></a></td>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;' valign='top'><a href='https://www.linkedin.com/' target='_blank'><img alt='LinkedIn' height='32' src='images/linkedin@2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;' title='LinkedIn' width='32'/></a></td>" +
                    "<td style='word-break: break-word; vertical-align: top; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;' valign='top'><a href='https://www.youtube.com/' target='_blank'><img alt='YouTube' height='32' src='images/youtube@2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: none; display: block;' title='YouTube' width='32'/></a></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<!--[if (!mso)&(!IE)]><!-->" +
                    "</div>" +
                    "<!--<![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->" +
                    "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->" +
                    "</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>" +
                    "<!--[if (IE)]></div><![endif]-->" +
                    "</body>" +
                    "</html>";
            message.setContent(file2, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email weryfikacji konta wysłany");

        } catch (MessagingException e) {


            throw new RuntimeException(e);
        }
    }


}
