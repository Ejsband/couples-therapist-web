package ru.couplestherapistweb.service;

import java.util.Map;

public interface UtilityService {
    Map<Integer, String> generateCaptcha();
    Integer getCaptchaNumber(Map<Integer, String> map);
    String getCaptchaString(Map<Integer, String> map);
}
