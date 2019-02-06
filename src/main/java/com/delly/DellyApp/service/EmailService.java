package com.delly.DellyApp.service;

/**
 * Interface for mail sending.
 *
 * @author spralas
 */
public interface EmailService {
    void sendMail(String to, String subject, String text);
}
