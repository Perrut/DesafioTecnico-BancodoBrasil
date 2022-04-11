import { Pagination } from "./pagination";
import { PovertyIndicator } from "./poverty-indicator";

export interface SearchResults {
    pagination: Pagination;
    povertyIndicatorList: PovertyIndicator[];
}