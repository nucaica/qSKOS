package at.ac.univie.mminf.qskos4j.result.custom;

import java.util.Map;
import java.util.Set;

import org.openrdf.model.URI;

import at.ac.univie.mminf.qskos4j.result.Result;

public class AvgConceptIndegreeResult extends Result<Map<URI, Set<URI>>> {

	public AvgConceptIndegreeResult(Map<URI, Set<URI>> data) {
		super(data);
	}

	@Override
	public String getShortReport() {
		long referencingResourcesCount = 0;
		
		float avgConceptRank = 0;
		if (getData().size() != 0) {
			avgConceptRank = (float) referencingResourcesCount / (float) getData().size();
		}
		
		return "value: " +avgConceptRank;
	}

	@Override
	public String getExtensiveReport() {
		String extensiveReport = "";
		
		for (URI resource : getData().keySet()) {
			Set<URI> refResources = getData().get(resource);
			
			if (!refResources.isEmpty()) {
				extensiveReport += "vocabulary resource: '" +resource.stringValue()+ "', referenced by: " +refResources+ "\n";
			}
		}

		return extensiveReport;
	}

}