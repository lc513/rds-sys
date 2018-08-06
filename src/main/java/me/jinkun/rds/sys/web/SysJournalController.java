package me.jinkun.rds.sys.web;

import me.jinkun.rds.sys.domain.SysJournal;
import me.jinkun.rds.sys.service.SysJournalService;
import me.jinkun.rds.sys.web.form.SysJournalForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journal")
public class SysJournalController {

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
    public Object addJournal(SysJournal sysJournal){

        return sysJournalService.addJournal(sysJournal);
    }
    /**
     * 修改日志
     * @param sysJournal
     * @return
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public Object updateJournal(SysJournal sysJournal){

        return sysJournalService.updateJournal(sysJournal);
    }
    /**
     * 删除日志
     * @param sysJournal
     * @return
     */
    @RequestMapping(value = "/delete" ,method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteJournal(SysJournal sysJournal){

        return sysJournalService.deleteJournal(sysJournal);
    }
}
