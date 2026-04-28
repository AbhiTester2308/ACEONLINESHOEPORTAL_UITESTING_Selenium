package com.AceOnlineShoePortal.Hooks;

import com.AceOnlineShoePoratl.Utilities.BrowserSetUp;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class hook extends BrowserSetUp{



    @BeforeAll
    public static void applicationLaunch(){
        BrowserSetUp.application_Launch();
    }

    @AfterAll
    public static void applicationQuit(){
        //BrowserSetUp.application_Quit();
    }


}


//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git push -u origin main