# /// script
# dependencies = ["markdown"]
# ///
"""Rebuild resources/prompting-cheat-sheet.html from the Markdown version.

Edit the .md, then run:  uv run tools/build-cheat-sheet.py
"""
import re
from pathlib import Path

import markdown

RES = Path(__file__).resolve().parent.parent / "resources"
REPO_URL = "https://github.com/parties/ai-workshop/blob/main/README.md"
PAGES = "https://parties.github.io/ai-workshop/resources/"


def convert(md):
    # GitHub links work on GitHub; on Pages, point README links at GitHub and keep Pages links local.
    md = md.replace("](../README.md", "](" + REPO_URL).replace("](" + PAGES, "](")
    return markdown.markdown(md, extensions=["tables", "fenced_code", "toc"])


TEMPLATE = """<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Prompting Cheat Sheet</title>
<style>
:root{
  --ink:#16202B; --ink-2:#3A4A5A; --ink-3:#6B7C8C;
  --paper:#E8EDF1; --paper-2:#F3F6F8; --rule:#C3CFD9;
  --anchor:#2F6F8F; --signal:#E5920C; --hot:#A33A28;
}
*{box-sizing:border-box}
body{margin:0;padding:0 0 60px;background:var(--paper);color:var(--ink);
  font-family:ui-sans-serif,system-ui,-apple-system,"Segoe UI",Roboto,Helvetica,Arial,sans-serif;
  font-size:19px;line-height:1.55}
.wrap{max-width:960px;margin:0 auto;padding:0 26px}
header{background:var(--ink);color:var(--paper);padding:44px 0 38px;margin-bottom:34px}
header h1{font-size:40px;margin:0 0 10px;letter-spacing:-1px;line-height:1.1}
header p{margin:0 0 10px;font-size:21px;color:#AEBDC9;max-width:66ch}
header p:last-child{margin:0}
header strong{color:var(--paper)}
header code{background:#2A3846;color:var(--paper);padding:1px 6px;border-radius:4px;font-size:.9em}
h2{font-size:15px;text-transform:uppercase;letter-spacing:1.1px;color:var(--ink-3);
  margin:44px 0 12px;padding-bottom:7px;border-bottom:2px solid var(--rule)}
h3{font-size:24px;letter-spacing:-.3px;margin:30px 0 8px;padding-left:12px;border-left:6px solid var(--signal)}
p{margin:0 0 14px;color:var(--ink-2)}
a{color:var(--anchor)}
code{font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:.88em;
  background:var(--paper-2);padding:1px 5px;border-radius:4px}
.snip{margin:0 0 18px}
pre{font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;font-size:16px;line-height:1.55;
  background:#fff;border:2px solid var(--rule);border-radius:9px;padding:15px 17px;
  margin:0;white-space:pre-wrap;overflow-wrap:break-word;color:var(--ink)}
.copy{font:inherit;font-size:16px;font-weight:700;padding:8px 15px;margin-top:9px;
  border:2px solid var(--ink-2);background:#fff;color:var(--ink);border-radius:8px;cursor:pointer}
.copy:hover{background:var(--paper-2)}
.copy.done{background:#E2F1EA;border-color:#2E7D5B;color:#2E7D5B}
table{width:100%;border-collapse:collapse;background:#fff;border:2px solid var(--rule);
  border-radius:10px;overflow:hidden;margin:0 0 18px;font-size:17px}
th,td{text-align:left;vertical-align:top;padding:10px 14px;border-bottom:1px solid var(--rule)}
th{background:var(--paper-2);font-size:14px;text-transform:uppercase;letter-spacing:.8px;color:var(--ink-3)}
tr:last-child td{border-bottom:0}
td a{text-decoration:none;font-weight:700}
footer{margin-top:44px;padding-top:20px;border-top:2px solid var(--rule);
  font-size:17px;color:var(--ink-3)}
footer p{color:var(--ink-3)}
@media (max-width:600px){
  body{font-size:17px}
  header h1{font-size:32px}
  header p{font-size:18px}
  table{font-size:15px}
  th,td{padding:8px 9px}
}
@media print{
  @page{margin:.5in .55in}
  body{background:#fff;font-size:9.5pt;line-height:1.4;padding:0}
  .wrap{max-width:none;padding:0}
  header{background:none;color:var(--ink);padding:0 0 6px;margin-bottom:6px;border-bottom:2px solid var(--ink)}
  header h1{font-size:18pt;margin:0 0 4px}
  header p{color:var(--ink-2);font-size:9.5pt;margin:0 0 4px}
  header strong{color:var(--ink)}
  .copy,th:last-child,td:last-child{display:none}
  p{margin:0 0 6px}
  h2{font-size:9pt;margin:12px 0 4px;padding-bottom:3px;break-after:avoid}
  h3{font-size:11pt;margin:10px 0 3px;border-left-width:4px;padding-left:8px;break-after:avoid}
  .snip{margin:0 0 6px}
  pre{font-size:8.5pt;line-height:1.4;padding:5px 8px;border-width:1px;border-radius:5px}
  .snip,tr{break-inside:avoid}
  table{font-size:9pt;border-width:1px;margin:0 0 8px}
  th,td{padding:4px 8px}
  footer{margin-top:12px;padding-top:6px;font-size:8.5pt}
  footer p:last-child{display:none}
  a{color:var(--ink);text-decoration:none}
}
</style>
</head>
<body>
<header>
  <div class="wrap">
    <h1>Prompting Cheat Sheet</h1>
    {{INTRO}}
  </div>
</header>
<main class="wrap">
{{BODY}}
<footer>
  {{FOOTER}}
  <p><a href="prompting-cheat-sheet.md">Markdown version</a> · <a href="https://github.com/parties/ai-workshop">The full workshop handout</a></p>
</footer>
</main>
<script>
document.addEventListener('click',function(ev){
  var b=ev.target.closest && ev.target.closest('.copy');
  if(!b) return;
  var txt=document.getElementById(b.dataset.for).textContent;
  var done=function(){
    var old=b.textContent;
    b.textContent='Copied'; b.classList.add('done');
    setTimeout(function(){ b.textContent=old; b.classList.remove('done'); },1600);
  };
  // Clipboard API is blocked in some file:// contexts, so keep the execCommand path as the fallback.
  if(navigator.clipboard && navigator.clipboard.writeText){
    navigator.clipboard.writeText(txt).then(done,function(){ legacy(txt,done); });
  } else { legacy(txt,done); }
});
function legacy(txt,done){
  var ta=document.createElement('textarea');
  ta.value=txt; ta.style.position='fixed'; ta.style.opacity='0';
  document.body.appendChild(ta); ta.select();
  try{ document.execCommand('copy'); done(); }catch(e){ ta.select(); }
  document.body.removeChild(ta);
}
</script>
</body>
</html>
"""


md = (RES / "prompting-cheat-sheet.md").read_text()
md = md.replace("# Prompting Cheat Sheet\n", "", 1)
intro, body = md.split("\n---\n", 1)
body, footer = body.rsplit("\n---\n", 1)
intro = intro.replace(
    "Hover over it on GitHub and click the copy\nbutton in the corner.", "Click **Copy** under it."
).replace("in a gray box", "in a box")

n = 0


def add_copy(m):
    global n
    n += 1
    return (f'<div class="snip"><pre id="p{n}">{m.group(1)}</pre>'
            f'<button class="copy" data-for="p{n}">Copy</button></div>')


body_html = re.sub(r"<pre><code>(.*?)\n?</code></pre>", add_copy, convert(body), flags=re.S)
body_html = body_html.replace("<hr />", "")

out = (TEMPLATE.replace("{{INTRO}}", convert(intro))
               .replace("{{BODY}}", body_html)
               .replace("{{FOOTER}}", convert(footer.strip())))
(RES / "prompting-cheat-sheet.html").write_text(out)
print(f"wrote prompting-cheat-sheet.html ({n} prompts)")
