/*
 * Copyright 2011
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.mojo.cobertura.its;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import junit.framework.TestCase;

/**
 * 
 */
public class Common extends TestCase {
    public void setUp() throws IOException 
    {
        String fileName = getClass().getName() + "-pid";
        File target = new File("target");
        if (! (target.exists() && target.isDirectory()) ) {
            target = new File (".");
        }
        File pidFile = new File(target, fileName);
        FileWriter fw = new FileWriter(pidFile);
        // DGF little known trick... this is guaranteed to be unique to the PID
        // In fact, it usually contains the pid and the local host name!
        String pid = ManagementFactory.getRuntimeMXBean().getName();
        fw.write( pid );
        fw.flush();
        fw.close();
    }


}
