/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.example.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

/**
 * Content Page.
 * @author Marcelo Fernandes
 */
@Setter
@Getter
@Named
@ViewScoped
public class ContentMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String page;

	@PostConstruct
	public void init() {
		String initPage = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("content");
		if (initPage != null && !initPage.trim().isEmpty()) {
			page = initPage;
		}
		else {
			page = "starter";
		}
	}
}
