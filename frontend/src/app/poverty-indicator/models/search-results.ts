import { Pagination } from "./pagination";
import { PovertyIndicator } from "./poverty-indicator-2";

export interface SearchResults {
    pagination: Pagination;
    povertyIndicatorList: PovertyIndicator[];
}