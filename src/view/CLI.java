/*
 * Copyright (c) 2016, Frédéric Fauberteau
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY FRÉDÉRIC FAUBERTEAU AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Frédéric Fauberteau
 */
public class CLI /* TODO: make this class a View */ {

    public void update(Observable o, Object arg) {
        new SwingWorker<List<String>,String>() {

            List<String> users = new ArrayList<>();

            @Override
            protected List<String> doInBackground() throws Exception {
                String[] data; // TODO: get data
                int index = 0;
                while (index < data.length && ! isCancelled()) {
                    users.add(data[index]);
                    publish((data[index]));
                    index++;
                }
                return users;
            }

            @Override
            protected void process(List<String> chunks) {
                for (String data : chunks) {
                    System.out.println(data);
                }
            }

            @Override
            protected void done() {
                System.out.println("---");
            }

        }.execute();
    }

}