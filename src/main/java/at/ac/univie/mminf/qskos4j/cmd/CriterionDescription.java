package at.ac.univie.mminf.qskos4j.cmd;

enum CriterionDescription {

	// Statistics
	TOTAL_CONCEPTS("c", 
		"All Concepts", 
		"Finds all SKOS concepts involved in the vocabulary", 
		"findInvolvedConcepts"),
	AUTHORITATIVE_CONCEPTS("ac", 
		"Authoritative Concepts", 
		"Finds all authoritative concepts in the vocabulary", 
		"findAuthoritativeConcepts"),
	LABELS_COUNT("cl",
		"Concept Labels",
		"Counts the number of relations between all concepts and lexical labels (prefLabel, altLabel, hiddenLabel and subproperties thereof)",
		"findLexicalRelationsCount"),
	SEMANTIC_RELATIONS_COUNT("sr",
		"Semantic Relations Count",
		"Counts the number of relations between concepts (skos:semanticRelation and subproperties thereof)",
		"findSemanticRelationsCount"),
	AGGREGATION_RELATIONS_COUNT("ar",
		"Aggregation Relations Count",
		"Counts the statements relating resources to ConceptSchemes or Collections",
		"findAggregationRelations"),
	CONCEPT_SCHEME("cs",
		"Concept Schemes",
		"Finds the involved ConceptSchemes",
		"findConceptSchemes"),
	COLLECTION_COUNT("cc",
		"Collection Count",
		"Counts the involved Collections",
		"findCollectionCount"),
	
	// Labeling and Documentation Issues
	OMITTED_OR_INVALID_LANG_TAGS("oilt",
		"Omitted or Invalid Language Tags",
		"Finds omitted or invalid language tags of text literals",
		"findOmittedOrInvalidLanguageTags"),
	INCOMPLETE_LANG_COVERAGE("ilc",	
		"Incomplete Language Coverage",
		"Finds concepts lacking description in languages that are present for other concepts",
		"findIncompleteLanguageCoverage"),
	UNDOCUMENTED_CONCEPTS("uc",
		"Undocumented Concepts",
		"Finds concepts that don't use any SKOS documentation properties",
		"findUndocumentedConcepts"),
	LABEL_CONFLICTS("lc",	
		"Label Conflicts",
		"Finds concepts with similar (identical) labels",
		"findLabelConflicts"),
				
	// Structural Issues		
	ORPHAN_CONCEPTS("oc", 
		"Orphan Concepts", 
		"Finds all orphan concepts, i.e. those not having semantic relationships to other concepts", 
		"findOrphanConcepts"),
	WEAKLY_CONNECTED_COMPONENTS("wcc", 
		"Weakly Connected Components", 
		"Finds all weakly connected components", 
		"findComponents"),
	CYCLIC_HIERARCHICAL_RELATIONS("chr", 
		"Cyclic Hierarchical Relations", 
		"Finds all hierarchy cycle containing components", 
		"findHierarchicalCycles"),
	VALUELESS_ASSOCIATIVE_RELATIONS("var", 
		"Valueless Associative Relations", 
		"Two concepts are sibling, but also connected by an associative relation", 
		"findValuelessAssociativeRelations"),
	SOLELY_TRANSITIVELY_RELATED_CONCEPTS("strc",
		"Solely Transitively Related Concepts",
		"Concepts only related by skos:broaderTransitive or skos:narrowerTransitive",
		"findSolelyTransitivelyRelatedConcepts"),
	OMITTED_TOP_CONCEPTS("otc",
		"Omitted Top Concepts",
		"Finds skos:ConceptSchemes without top concepts",
		"findOmittedTopConcepts"),
	TOP_CONCEPTS_HAVING_BROADER_CONCEPTS("tchbc",
		"Top Concepts Having Broader Concepts",
		"Finds top concepts internal to the vocabulary hierarchy tree",
		"findTopConceptsHavingBroaderConcepts"),	
		
	// Linked Data Specific Issues
	MISSING_INLINKS("mil",
		"Missing In-Links",
		"Uses the sindice index to find concepts that aren't referenced by other datasets on the Web",
		"findMissingInLinks"),	
	MISSING_OUTLINKS("mol",
		"Missing Out-Links",
		"Finds concepts that are not linked to other vocabularies on the Web",
		"findMissingOutLinks"),
	LINK_TARGET_AVAILABILITY("bl",
		"Broken Links",
		"Checks dereferencability of all links",
		"findBrokenLinks"),
	UNDEFINED_SKOS_RESOURCES("usr",
		"Undefined SKOS Resources",
		"Finds 'invented' new terms within the SKOS namespace or deprecated properties",	
		"findUndefinedSkosResources"),
		
	// Other Issues	
	HIERARCHICALLY_AND_ASSOCIATIVELY_RELATED_CONCEPTS("harc",
		"Hierarchically and Associatively Related Concepts",
		"Concepts that are both hierarchically and associatively connected",
		"findAmbiguousRelations"),
	UNIDIRECTIONALLY_RELATED_CONCEPTS("urc",
		"Unidirectionally Related Concepts",
		"Concepts not including reciprocal relations",	
		"findOmittedInverseRelations"),		
	
	HTTP_URI_SCHEME_VIOLATION("husv",
		"HTTP URI Scheme Violation",
		"Finds triple subjects that are no HTTP URIs",
		"findNonHttpResources"),
	
	ASS_VS_HIER_RELATION_CLASHES("ahrc",
		"Associative vs. Hierarchical Relation Clashes",
		"Covers condition S27 from the SKOS reference document",
		"findAssociativeVsHierarchicalClashes"),
	EXACT_VS_ASS_MAPPING_CLASHES("eamc",
		"Exact vs. Associative and Hierarchical Mapping Clashes",
		"Covers condition S46 from the SKOS reference document",	
		"findExactVsAssociativeMappingClashes"),
	
	AMBIGUOUS_PREFLABELED_CONCEPTS("apc",
		"Ambiguously Preflabeled Concepts",
		"Finds concepts with more then one prefLabel per languate",	
		"findNotUniquePrefLabels"),
	NOT_DISJOINT_LABELED_CONCEPTS("ndlc",
		"Not Disjoint Labeled Concepts",
		"Finds concepts with identical entries for different label types",
		"findNotDisjointLabels"),
		
	NULL_DESC("", "", "", "");
	
	private String id, name, description, qSkosMethodName;
	
	CriterionDescription(String id, String name, String description, String qSkosMethodName) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.qSkosMethodName = qSkosMethodName;
	}
	
	String getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	String getDescription() {
		return description;
	}
	
	String getQSkosMethodName() {
		return qSkosMethodName;
	}
	
	static CriterionDescription findById(String id) {
		for (CriterionDescription critDesc : values()) {
			if (critDesc.id.equals(id)) {
				return critDesc;
			}
		}
		return NULL_DESC;
	}
}
