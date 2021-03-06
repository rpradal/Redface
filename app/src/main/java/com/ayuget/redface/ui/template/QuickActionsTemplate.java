/*
 * Copyright 2015 Ayuget
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ayuget.redface.ui.template;

import android.content.Context;

import com.ayuget.redface.account.UserManager;
import com.ayuget.redface.data.api.model.Post;
import com.squareup.phrase.Phrase;

public class QuickActionsTemplate extends HTMLTemplate<Post> {
    private static final String QUICK_ACTIONS_TEMPLATE = "post_quick_actions.html";

    private final UserManager userManager;

    public QuickActionsTemplate(Context context, UserManager userManager) {
        super(context, QUICK_ACTIONS_TEMPLATE);
        this.userManager = userManager;
    }

    @Override
    protected void render(Post post, Phrase templateContent, StringBuilder stream) {
        if (userManager.isActiveUserLoggedIn()) {
            stream.append(templateContent.put("post_id", String.valueOf(post.getId())).format().toString());
        }
        else {
            stream.append("");
        }
    }
}
