/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

const twoSum = function (nums, target) {
    const nums_len = nums.length;
    for (let x = 0; x < nums_len; x++) {
        for (let y = x + 1; y < nums_len; y++) {
            if ((nums[x] + nums[y]) == target) {
                return [x, y];
            }
        }
    }
};
