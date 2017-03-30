package main.java.vidor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/demo")
public class RestController {

    @RequestMapping(value="/query_users", method= RequestMethod.POST)
    public @ResponseBody TResult<UserInfo> queryUsers() {

        TResult<UserInfo> total = new TResult<UserInfo>();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setUsername("李雷");
        userInfo.setAge(18);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId("2");
        userInfo2.setUsername("chen");
        userInfo2.setAge(50);

        List<UserInfo> users = new ArrayList<>();
        users.add(userInfo);
        users.add(userInfo2);

        total.setValue(users);
        total.setSuccess(true);

        return total;
    }

//    @RequestMapping(value="/query_user_by_id", method= RequestMethod.GET)
//    public @ResponseBody TResult<UserInfo> queryUserById(@RequestParam(value="user_id", required = true) String userId) {
//        TResult<UserInfo> result = new TResult<UserInfo>();
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(userId);
//        userInfo.setUsername("李雷");
//        userInfo.setAge(18);
//        result.setValue(userInfo);
//        result.setSuccess(true);
//        return result;
//    }

    @RequestMapping(value = "/status")
    public ResponseEntity responseEntityStatusCode() {
        return ResponseEntity.status(HttpStatus.OK).body(new UserInfo("12","chen",12));
    }
}
