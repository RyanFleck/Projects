#!/usr/bin/python3

import pandas as pd
import numpy as np
import rcf_logs as rcf

rcf.intro("Pandas Experiments", 2018)

# Create basic series
s = pd.Series([1, 3, 5, 4, 67, 34, 4, 66, 7, 88, 2])
print(s)
