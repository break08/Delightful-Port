# fix_tab.py  —  python3 fix_tab.py DelightfulRecipeProvider.java
import re, sys
path = sys.argv[1]
s = open(path, encoding='utf-8').read()
out, pos, n = [], 0, 0
for m in re.finditer(r'wrap\(CookingPotRecipeBuilder\.cookingPotRecipe\(', s):
    start = m.start()
    if start < pos:
        continue
    e = re.compile(r',\s*\n\s*"').search(s, start)   # dấu phẩy trước tên recipe
    if not e:
        continue
    if 'setRecipeBookTab' not in s[start:e.start()]:
        out.append(s[pos:e.start()])
        out.append('\n                        .setRecipeBookTab(CookingPotRecipeBookTab.MISC)')
        pos = e.start()
        n += 1
out.append(s[pos:])
open(path, 'w', encoding='utf-8').write(''.join(out))
print("patched", n, "recipes")