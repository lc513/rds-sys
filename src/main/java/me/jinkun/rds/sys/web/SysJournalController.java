package me.jinkun.rds.sys.web;

import com.google.gson.Gson;
import me.jinkun.rds.sys.domain.SysJournal;
import me.jinkun.rds.sys.service.SysJournalService;
import me.jinkun.rds.sys.web.form.SysJournalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/journal")
public class SysJournalController {
//    @InitBinder
//    //此方法用于日期的转换，如果未加，当页面日期格式转换错误，将报400错误，实际是因为此方法
//    public void initBinder(WebDataBinder binder) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        dateFormat.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }
    @Autowired
    SysJournalService sysJournalService;

    @RequestMapping("/topage/{ui}")
    public String toPage(@PathVariable String ui){
        return "/sys/sys-journal/sys-journal-"+ui;
    }
    /**
     * 查看日志
     * @param sysJournal
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/select" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getJournals(SysJournalForm sysJournal, @RequestParam(defaultValue = "1") int offset, @RequestParam(defaultValue = "10") int limit){

        return sysJournalService.getJournal(sysJournal,offset,limit) ;
    }
    /**
     * 添加日志
     * @param sysJournal
     * @return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public Object addJournal(SysJournalForm sysJournal){

        return sysJournalService.addJournal(sysJournal);
    }
    /**
     * 修改日志
     * @return
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public Object updateJournal(SysJournalForm sysJournal){
        String s = new Gson().toJson(sysJournal);
        System.out.println(s);
        return sysJournalService.updateJournal(sysJournal);
    }
    /**
     * 删除日志
     * @param sysJournal
     * @return
     */
    @RequestMapping(value = "/delete" ,method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteJournal(SysJournalForm sysJournal){

        return sysJournalService.deleteJournal(sysJournal);
    }
}
