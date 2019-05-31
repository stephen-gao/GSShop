package com.gao.web;

import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import com.gao.entity.vo.BaseVO;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author gs
 * @Date created time 2019/5/28 16:32
 * @Description
 */
@RestController
public class BaseController {

    protected static List setPageSort(BaseVO vo){
        if(!CollectionUtils.isEmpty(vo.getSortList())){
            List<String> list = new ArrayList<>();
            //驼峰转下划线
            for(int i = 0; i<vo.getSortList().size();i++){
                list.add(humpToLine(vo.getSortList().get(i)));
            }
            return list;
        }
        return null;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线 */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @GetMapping("/notlogin")
    @ResponseBody
    public Result notlogin(){
        return ResultFactory.getDefaultResult(ResultEnum.NOTLOGIN);
    }

    @GetMapping("/noAuthority")
    @ResponseBody
    public Result noAuthority(){
        return ResultFactory.getDefaultResult(ResultEnum.UNAUTHORIZED);
    }
}
