export function getFullDayName(shortDay) {
    switch (shortDay) {
        case 'H':
        return 'Hétfő';
    
        case 'K':
        return 'Kedd';
    
        case 'Sze':
        return 'Szerda';
    
        case 'Cs':
        return 'Csütörtök';
    
        case 'P':
        return 'Péntek';
    
        case 'Szo':
        return 'Szombat';
    
        case 'V':
        return 'Vasárnap';
    
        default:
        return '';
    }
}