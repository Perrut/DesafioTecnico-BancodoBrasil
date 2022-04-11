import { Country } from "./country";
import { Indicator } from "./indicator";

export interface PovertyIndicator {
    indicator?: Indicator;
    country?: Country;
    countryiso3code: string;
    date: string;
    value: number;
    unit: string;
    obs_status: string;
    decimal: number;
}
