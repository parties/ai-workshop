# Prompting Cheat Sheet

The four parts get your first prompt right. This page is for everything after it: the
back-and-forth that turns a decent first answer into something you'd actually hand to students.

Everything in a gray box is meant to be copied as-is. Hover over it on GitHub and click the copy
button in the corner. Swap out anything in `[BRACKETS]`.

---

## The fix-it table

| If it… | Say… | More |
|---|---|---|
| Starts building before it understands what you want | *"Before you start, interview me one question at a time."* | [↓](#make-it-interview-you) |
| Builds the wrong thing and you've wasted twenty minutes | *"Show me an outline first and wait for my OK."* | [↓](#make-it-show-you-first) |
| Asks you questions one at a time, forever | *"Put all your questions in one numbered list with your recommended answer for each."* | [↓](#get-all-its-questions-at-once) |
| Gives you options but no opinion | *"What would you do, and why?"* | [↓](#ask-what-it-thinks) |
| Writes four paragraphs when you needed one | *"Be brief."* | [↓](#when-it-talks-too-much) |
| Ignores the one thing you said mattered | *"That still does X, which is what I'm trying to avoid."* | [↓](#when-it-missed-the-point) |
| Can't fix a problem you keep describing | Paste or screenshot the actual problem. | [↓](#show-it-dont-describe-it) |
| Sounds like a brochure | *"This sounds like AI. Rewrite it like a teacher talking to a colleague."* | [↓](#when-it-sounds-like-ai) |
| Lost you three messages ago | *"I don't follow. Re-explain with more context and no jargon."* | [↓](#when-you-cant-follow-it) |
| Reprints the whole document every time you change one line | *"Put this in a document and edit it there."* | [↓](#asking-for-a-document) |
| Forgets things you told it earlier | Start a new chat with a summary. | [↓](#when-a-long-chat-goes-sideways) |

---

## 1. Before it builds anything

### Make it interview you

The single biggest upgrade. Most bad output comes from the AI guessing at things you never said.
Make it ask instead.

Three sizes, from quick to thorough.

**One line**, for quick stuff: an email, a single handout.

```
Before you start, interview me one question at a time until you understand what I need.
```

**A paragraph**, for something your students will use this week.

```
I want to make [WHAT YOU'RE MAKING]. Before you make anything, interview me. Ask me one question at a time about who it's for, what they already know, what it needs to accomplish, and any limits I'm working with (time, length, format). Keep asking follow-up questions until you could describe the finished thing back to me and I'd say "yes, that's it." Then describe it back to me and wait for my OK.
```

**The full grilling**, for anything you'll live with for a semester: a unit, a syllabus, a
project and its rubric.

```
I want to make [WHAT YOU'RE MAKING] for [WHO IT'S FOR]. Don't make anything yet. First, interview me until we agree on exactly what it should be.

How to run the interview:
- Treat this as a decision tree. Every answer I give opens up new decisions. Only ask about decisions I can make right now. Save any question that depends on an answer you haven't heard yet.
- Ask 1 to 3 questions per round, never more.
- Make every question multiple choice: options A, B, C, plus "something else." Put the option you'd recommend first and tell me why in one line.
- I'll answer like this: 1A, 2C, 3 something else: [my answer].
- Don't ask me anything you could figure out from what I've already told you.
- If one of my answers contradicts an earlier one, point it out before moving on.
- Keep going until every branch is settled. Then give me a numbered summary of every decision we made and wait for my OK before you make anything.
```

Why the full version works: multiple choice with a recommendation means you're reacting, not
inventing. Answering "1A, 2C" takes five seconds. Typing a paragraph for every question is how
interviews get abandoned halfway.

### Make it show you first

Fixing an outline costs one message. Fixing a finished unit costs an afternoon.

```
Before you make anything, show me a short outline of what you'll build (sections, length, format) and list any assumptions you're making. Wait for my OK.
```

The assumptions list is the useful part. That's where you find out it thought your class was
55 minutes, not 90.

### Get all its questions at once

The opposite of the interview, for when you'd rather answer everything in one go.

```
If you have questions before you start, put them all in one numbered list with your recommended answer for each. I'll reply by number.
```

Then reply like this: *"1 yes, 2 B, 3 through 7 go with your picks."* One round instead of
twenty, and it has to commit to an opinion on every question.

### Ask what it thinks

It will happily give you three options and no opinion. Make it pick.

```
What would you do, and why?
```

Also good: *"Which of these would you cut?"* and *"What's the weakest part of this?"* Treat it
like a colleague with a view, not a typist.

---

## 2. While it's working

### When it talks too much

Go up the ladder until it behaves:

```
Be brief.
```

```
Three bullets max.
```

```
No intro, no recap, no "let me know if you'd like…" at the end.
```

```
For the rest of this chat, keep every answer under 100 words unless I ask for more.
```

Tired of typing it every time? Put the last one in your **Project / Gem / Custom GPT
instructions** and never say it again. That's [the whole point of the workshop](../README.md#the-idea).

### When it missed the point

Don't just say "try again." Say what it missed and why it matters, then ask for options:

```
That still [WHAT IT'S STILL DOING], which is what I'm trying to avoid. Give me five other ideas and I'll pick one.
```

Restating your limit fixes this answer. Asking for five fixes the next one too, because you're
choosing instead of hoping.

### Show it, don't describe it

*"The table looks weird"* gets you a guess. Pasting the table gets you a fix.

Paste the actual output that's wrong. Screenshot the thing that looks off. If the problem is what
students turned in, paste an example, **with the name removed**. See
[Student privacy](../README.md#student-privacy).

### When it sounds like AI

Say what's wrong and what you want instead. "Make it better" gives it nothing to work with.

```
This sounds like AI: too generic, too upbeat. Rewrite it like a teacher explaining this to a colleague.
```

Swap in your own complaint. *Too salesy, too formal, too many dashes, reads like a press
release.* The more specific, the better the rewrite.

### When you can't follow it

Its job is to make sense to you, not the other way around.

```
I don't follow. Re-explain that with more context and no jargon.
```

---

## 3. Documents you'll keep

### Asking for a document

By default it answers in the chat, which means every change reprints the whole thing and the
version you want is buried twelve messages up. Ask for a document instead:

```
Put this in a document, not the chat. When I ask for changes, edit the document. Don't reprint it.
```

Each platform calls the document something different. In Claude it's an **Artifact**, and in
ChatGPT and Gemini it's a **Canvas**. Same idea in all three: a separate pane you can keep
editing.

To get it out, use the copy or download button on the document. If you'll paste it into Google
Docs, ask for it in **Markdown**, then use **Edit → Paste from Markdown** in Docs. You may have
to turn on Markdown in **Tools → Preferences** first. UIs move. Look for the word "Markdown."

### Bigger document, more steps first

The bigger the document, the more you settle before it writes anything.

| Making a… | Do this |
|---|---|
| **Lesson plan** | One good [four-part prompt](../README.md#the-four-parts), then [show me first](#make-it-show-you-first). |
| **Unit outline** | [Paragraph interview](#make-it-interview-you), then an outline, then approve it, then fill it in **one lesson at a time**. |
| **Syllabus** | [Full grilling](#make-it-interview-you), then paste your district or department requirements, then build it **one section at a time**, then run the check below. |

The check at the end of a syllabus:

```
Go through the requirements I pasted, one by one, and tell me which ones this document doesn't meet yet.
```

Why one section at a time: a long chat isn't a bucket that holds everything you poured in. The
AI pays less attention to things the further back they are, and a whole syllabus in one shot
is where it starts quietly dropping your requirements. The details are in
[how context windows actually work](https://parties.github.io/ai-workshop/resources/context-window-drift.html).

---

## 4. Before you use it

### What am I missing

```
What am I not thinking of here? Rank it by what would cause the most trouble.
```

It won't catch everything. It will catch the thing you'd have found out about in second period.

### Quiz me

It just helped you write material you're about to teach. Make sure you know it cold.

```
Quiz me on this before I teach it. One question at a time, and don't tell me the answer until I've tried.
```

### Check it against your list

Tell it what done looks like, then make it grade itself:

```
Here's what this needs to have: [YOUR CHECKLIST]. Go through it item by item and tell me which ones aren't met yet.
```

It's still your job to read the result. But it's a lot faster to check a list than to reread
three pages.

### When a long chat goes sideways

It's forgetting things you said, contradicting itself, or getting worse with every answer. Don't
keep pushing. Start over, and bring the good parts with you:

```
Write me a prompt I can paste into a new chat that picks up exactly where we are: what we're making, every decision we've made, and what's left to do.
```

Paste that into a new chat. A clean start with a good summary usually beats message forty of the old one.

---

*Free to reuse in your own classroom or PD. Attribution appreciated, not required.*
