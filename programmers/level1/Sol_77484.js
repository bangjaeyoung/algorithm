function solution(lottos, wins) {
    let zero = 0;
    let same = 0;
    
    for (let i = 0; i < 6; i += 1) {
        const lotto = lottos[i];
        
        if (lotto === 0) {
            zero += 1;
            
            continue;
        }
        
        for (let j = 0; j < 6; j += 1) {
            const win = wins[j];
            
            if (lotto === win) {
                same += 1;
            }
        }
    }
    
    if (same === 0 && zero === 0) return [6, 6];
    if (same === 0) return [7 - zero, 6];   
    
    return [7 - same - zero, 7 - same]
}