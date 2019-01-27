function mergeStrings(a, b) {
    const len_a = a.length;
    const len_b = b.length;
    const a_greaterthan_b = len_a > len_b;
    const a_equalto_b = len_a === len_b;
    const shortest_str = a_greaterthan_b ? len_b : len_a;
    const ans = [];

    let x = 0;
    for (x; x < shortest_str; x++) {
        ans.push(a[x]);
        ans.push(b[x]);
    }

    if (!a_equalto_b) {
        ans.push((a_greaterthan_b ? a : b).substring(x));
    }

    return ans.join('');
}

// i4