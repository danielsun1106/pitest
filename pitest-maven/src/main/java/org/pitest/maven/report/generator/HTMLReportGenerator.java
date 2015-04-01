/*
 * Copyright 2015 Jason Fehr
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.maven.report.generator;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class HTMLReportGenerator implements IReportGenerationStrategy {

	public ReportGenerationResultEnum generate(ReportGenerationContext context) {
		try {
			context.getLogger().debug("HTMLReportGenerator using directory [" + context.getReportsDataDirectory() + "] as directory containing the html report");
			context.getLogger().debug("HTMLReportGenerator using directory [" + context.getSiteDirectory() + "] as directory that is the destination of the site report");
			FileUtils.copyDirectory(context.getReportsDataDirectory(), context.getSiteDirectory());
		} catch (IOException e) {
			context.getLogger().warn(e);
			return ReportGenerationResultEnum.FAILURE;
		}
		
		return ReportGenerationResultEnum.SUCCESS;
	}
	
	public String getGeneratorName() {
		return "HTMLReportGenerator";
	}
	
	public String getGeneratorDataFormat() {
		return "HTML";
	}

}
