package com.delly.DellyApp.service;

/**
 * Interface for mail sending.
 */
public interface EmailService {
    /**
     * Send e-mail.
     *
     * @param to      Receiver.
     * @param subject Subject.
     * @param text    Mail context.
     */
    void sendMail(String to, String subject, String text);
}
