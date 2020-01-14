def duplicate_count(text):
    character_once = [] 
    character_over_once = []
    for char in text:
        char = char.lower() 
        if char in character_once and char not in character_over_once:
            character_over_once.append(char)
        if char not in character_once:
            character_once.append(char)
    
    return len(character_over_once)
            
            
