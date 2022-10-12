package ru.couplestherapistweb.service.impl;

import org.springframework.stereotype.Service;
import ru.couplestherapistweb.service.UtilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Override
    public Map<Integer, String> generateCaptcha() {

        Map<Integer, String> map = new LinkedHashMap<>();

        String plus = "плюс";
        String multiplication = "умножить";

        int randomOne = new Random().nextInt(10) + 1;
        int randomTwo = new Random().nextInt(10) + 1;
        int randomThree = new Random().nextInt(10) + 1;

        int variant = new Random().nextInt(3) + 1;

        if (variant == 1) {
            map.put(randomOne * (randomThree + randomTwo), randomOne + multiplication + "(" + randomThree + plus + randomTwo + ")");
        } else if (variant == 2) {
            map.put(randomOne + (randomThree * randomTwo), randomOne + plus + "(" + randomThree + multiplication + randomTwo + ")");
        } else if (variant == 3) {
            map.put(randomOne * randomThree + randomTwo, randomOne + multiplication + randomThree + plus + randomTwo);
        } else if (variant == 4) {
            map.put(randomOne + randomThree * randomTwo, randomOne + plus + randomThree + multiplication + randomTwo);
        }
        return map;
    }

    @Override
    public Integer getCaptchaNumber(Map<Integer, String> map) {
        Map.Entry<Integer,String> entry = map.entrySet().iterator().next();
        return entry.getKey();
    }

    @Override
    public String getCaptchaString(Map<Integer, String> map) {
        Map.Entry<Integer,String> entry = map.entrySet().iterator().next();
        return entry.getValue();
    }
}
